package Boggle

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}
import scala.scalajs.js
import js.JSConverters._

import org.querki.jquery._
import org.querki.jquery
import org.scalajs.dom
import dom.document

import dom.ext._ // including `Ajax`
import scala.scalajs
            .concurrent
            .JSExecutionContext
            .Implicits
            .runNow

object Main extends js.JSApp {
  lazy val baseURL = $("#meta-baseurl").attr("baseURL")

  val dice = getDice()
  val dict = getDict()
  val board = Board(dice, dict)

  def readContent(url: String): String = {
    var content = ""
    
    val ajaxSettings = js.Dynamic.literal(
      url = url,
      `type` = "GET",
      success = (data: String) => content += data,
      async = false
    ).asInstanceOf[jquery.JQueryAjaxSettings]

    $.ajax(ajaxSettings)

    return content
  }

  def getDice() = {
    val pathToDice = s"${baseURL}/assets/txt/dice.txt"
    val lines = readContent(pathToDice).trim.split("\n").toVector
    lines.map(line => Die(line.trim.split(",").toVector))
  }

  def getDict() = {
    val pathToDict = s"${baseURL}/assets/txt/scrabble_dict.txt"
    readContent(pathToDict).trim.split("\n").toVector
  }

  def setupUI() {
    // Add a shuffle button
    $("#btn-shuffle").click(() => showBoard())

    // Add a show-solution button
    $("#btn-solution").click(() => showSolution())

    showBoard()
  }

  def showBoard() {
    $("#board .scratch").empty()
    board.shuffle()

    board.letters.vec.foreach{ 
      row => {
        val paddedRow = row.map(c => f"$c%2s")
                           .mkString(" ")
                           .replace(" ", "&nbsp")
        $("#board .scratch").append(s"<p>${paddedRow}</p>")
      }
    }

    $("#solution .scratch").empty()
  }

  def showSolution() {
    if ($("#solution .scratch").children().length == 0) {
      println("Solving board ...")
      val solution = board.solve()
      $("#solution .scratch").empty()
      $("#solution .scratch").append(s"<p>${solution.mkString(", ")}</p>")
    } else {
      println("Toggle solutions.")
      $("#solution .scratch p").toggleClass("hide")
    }
  }

  def main() = {
    setupUI()
    println("Let's play Boggle!")
  }
}
