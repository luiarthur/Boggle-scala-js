package Boggle

import Helper.isSquare
import org.scalatest._

class TestSuite extends FunSuite {
  val testDice: Vector[Die] = {
    Vector.fill(16)(Die(Vector("A", "B", "N")))
  }

  val testDict: Vector[String] = {
    Vector("BAN", "NAB", "ANN", "CAN", "BANANA")
  }

  test("isSquare") {
    List.range(0, 100).foreach{
      n => assert(isSquare(n * n))
    }
  }

  test("5 is not square") {
    assert(!isSquare(5))
  }

  test("Matrix") {
    val m = new Boggle.Matrix(Vector.range(0,15), 3, 5)
    println(m)
    println()

    println(m.shuffled)
    println()
  }

  test("Path contains Coord") {
    val path = Vector(Coord(1,0), Coord(2, 2))
    assert(path.contains(Coord(2, 2)))
  }

  test("Solve Board") {
    import scala.scalajs.js
    import js.JSConverters._

    val board = Board(testDice, testDict)
    val sol = board.solve()

    println("Board:")
    println(board)

    println("Solution:")
    println(sol.toList)
  }
}
