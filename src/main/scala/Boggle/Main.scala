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

  // TODO: Fix this hack!
  def getDice() = {
    // val lines = readContent("/assets/txt/dice.txt").trim.split("\n").toVector
    val lines = readContent("Boggle-scala-js/assets/txt/dice.txt").trim
                                                                  .split("\n")
                                                                  .toVector
    lines.map(line => Die(line.trim.split(",").toVector))
  }

  // TODO: Fix this hack!
  def getDict() = {
    // readContent("/assets/txt/scrabble_dict.txt").trim.split("\n").toVector
    readContent("Boggle-scala-js/assets/txt/scrabble_dict.txt").trim.split("\n").toVector
  }

  def setupUI() {
    $("#root").append("<div id='board' " +
                      "style='font-family: monospace; font-size: 25'>" + 
                      "</div>")

    $("#root").append("<div id='solution' " +
                      "style='font-family: monospace; " +
                      "font-size: 25; width: 50%'></div>")

    // Add a shuffle button
    $("#board").append("<button type='button' id='btn-shuffle'>" + 
                       "Shuffle Board</button>")
    $("#board").append("<div id='board-grid'><div>")
    $("#btn-shuffle").click(() => showBoard())

    // Add a show-solution button
    $("#solution").append("<button type='button' id='btn-solution'>" +
                          "Show Solution</button>")
    $("#solution").append("<div id='solution-grid'><div>")
    $("#btn-solution").click(() => showSolution())

    showBoard()
  }

  def showBoard() {
    $("#board-grid").empty()
    board.shuffle
    board.letters.vec.foreach{ 
      row => {
        val paddedRow = row.map(c => f"$c%2s")
                           .mkString(" ")
                           .replace(" ", "&nbsp")
        $("#board-grid").append(s"<p>${paddedRow}</p>")
      }
    }
    $("#solution-grid").empty()
  }

  def showSolution() {
    val solution = board.solve()
    $("#solution-grid").empty()
    $("#solution-grid").append(s"<p>${solution.mkString(", ")}</p>")
  }

  def main() = {
    setupUI()

    println("Let's play Boggle!")
  }
}
