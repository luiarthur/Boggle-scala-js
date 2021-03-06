package Boggle

// import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}
// import scala.scalajs.js
// import js.JSConverters._

import scala.util.Random
import Helper.isSquare

case class Board(dice: Vector[Die],
                 dictionary: Vector[String],
                 minLetters: Int=3) {

  val numDice = dice.size
  require(isSquare(numDice))

  val nrow = math.sqrt(numDice).toInt
  val ncol = nrow

  var letters = (new Matrix(dice.map(_.roll), nrow, ncol)).shuffled

  val shortDict = dictionary.filter(w => w.length >= minLetters)

  def shuffle(): Unit = {
    letters = (new Matrix(dice.map(_.roll), nrow, ncol)).shuffled
  }

  private val allMoves = List(
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

  def chain(path: Vector[Coord]): String = {
    path.map(coord => letters(coord.x, coord.y)).mkString("")
  }

  def visited(path: Vector[Coord], pos: Coord): Boolean = {
    return path.contains(pos)
  }

  def onBoard(pos: Coord): Boolean = {
    val (r, c) = (pos.x, pos.y)
    return r >= 0 && c >= 0 && r < nrow && c < ncol
  }

  def makeMove(path: Vector[Coord], move: Coord): Coord = {
    return path.last + move
  }

  def isValidMove(path: Vector[Coord], move: Coord): Boolean = {
    val pos = makeMove(path, move)
    return (!visited(path, pos)) && onBoard(pos)
  }

  /** Solve entier Boggle board. */
  def solve(): Vector[String] = {
    val allSolutions = Vector.tabulate(nrow, ncol){
      (r, c) => _solve(shortDict, Vector(Coord(r, c)))
    }.map(_.flatten)

    return allSolutions.flatten.distinct
                       .sorted
                       .sortBy(_.length)
  }

  private def _solve(dict: Vector[String], path: Vector[Coord],
                     solution: Vector[String]=Vector()): Vector[String] = {
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

      return sols.flatten.distinct.toVector
    }
  }
}
