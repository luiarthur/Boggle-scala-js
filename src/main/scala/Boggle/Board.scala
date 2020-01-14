package Boggle

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}
import scala.scalajs.js
import js.JSConverters._

import scala.util.Random
import Helper.isSquare

@JSExportTopLevel("Board")
case class Board(dice: js.Array[Die] = Helper.defaultDice,
                 dictionary: js.Array[String] = Helper.defaultDict,
                 minLetters: Int=3) {

  @JSExport
  val numDice = dice.size
  require(isSquare(numDice))

  @JSExport
  val nrow = math.sqrt(numDice).toInt

  @JSExport
  val ncol = nrow

  @JSExport
  var letters = (new Matrix(dice.toArray.map(_.roll), nrow, ncol))
  letters.shuffle

  @JSExport
  val shortDict = dictionary.filter(w => w.length >= minLetters)

  @JSExport
  def shuffle(): Unit = {
    letters = (new Matrix(dice.toArray.map(_.roll), nrow, ncol))
    letters.shuffle
  }

  private val allMoves = Vector(
    Coord(0, 1),
    Coord(1, 0),
    Coord(1, 1),
    Coord(-1, -1),
    Coord(0, -1),
    Coord(-1, 0),
    Coord(-1, 1),
    Coord(1, -1)
  )

  override def toString() = letters.toString()

  def chain(path: Array[Coord]): String = {
    path.map(coord => letters(coord.x, coord.y)).mkString("")
  }

  def visited(path: Array[Coord], pos: Coord): Boolean = {
    return path.contains(pos)
  }

  def onBoard(pos: Coord): Boolean = {
    val (r, c) = (pos.x, pos.y)
    return r >= 0 && c >= 0 && r < nrow && c < ncol
  }

  def makeMove(path: Array[Coord], move: Coord): Coord = {
    return path.last + move
  }

  def isValidMove(path: Array[Coord], move: Coord): Boolean = {
    val pos = makeMove(path, move)
    return (!visited(path, pos)) && onBoard(pos)
  }

  /** Solve entier Boggle board. */
  @JSExport
  def solve(): js.Array[String] = {
    val allSolutions = Array.tabulate(nrow, ncol){
      (r, c) => _solve(shortDict, Array(Coord(r, c)))
    }.map(_.flatten)

    return allSolutions.flatten.distinct.toJSArray
                       .sorted
                       .sortBy(_.length)
  }

  private def _solve(dict: js.Array[String], path: Array[Coord],
                     solution: Array[String]=Array()): Array[String] = {
    if (dict.size == 0) return solution else {
      // All valid moves
      val validMoves = allMoves.filter{move => isValidMove(path, move)}

      // Create each possible chain, given current path.
      val sols = validMoves.map{move =>
        val newPath = path :+ makeMove(path, move)
        val head = chain(newPath).toUpperCase
        val newDict = dict.filter(word => word.startsWith(head))
        val newSolution = if (newDict.contains(head)) solution :+ head else solution
        _solve(newDict, newPath, newSolution)
      }

      return sols.flatten.distinct.toArray
    }
  }
}
