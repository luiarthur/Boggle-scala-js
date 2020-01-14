package Boggle

import Helper.isSquare
import org.scalatest._

class TestSuite extends FunSuite {
  test("isSquare") {
    List.range(0, 100).foreach{
      n => assert(isSquare(n * n))
    }
  }

  test("5 is not square") {
    assert(!isSquare(5))
  }

  test("Matrix") {
    val m = new Boggle.Matrix(Array.range(0,15), 3, 5)
    m(0, 0) = 20
    println(m)
    println()

    m.shuffle()
    println(m)
    println()
  }

  test("Path contains Coord") {
    val path = Array(Coord(1,0), Coord(2, 2))
    assert(path.contains(Coord(2, 2)))
  }

  test("Solve Board") {
    import scala.scalajs.js
    import js.JSConverters._

    val board = Board()
    board.shuffle()
    val sol = board.solve()

    println("Board:")
    println(board)

    println("Solution:")
    println(sol)
  }


}
