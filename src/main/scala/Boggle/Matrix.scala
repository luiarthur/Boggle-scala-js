package Boggle

import scala.util.Random.shuffle
import scala.reflect.ClassTag

case class Matrix[T: ClassTag](vec: Vector[Vector[T]]){
  val nrow = vec.size
  val ncol = vec(0).size
  val nelem = nrow * ncol
  vec.foreach(row => require(row.size == ncol))

  def apply(x: Int, y: Int): T = vec(x)(y)

  override def toString() = {
    vec.map(row => row.map(x => f"$x%2s").mkString(" ")).mkString("\n")
  }

  def this(v: Vector[T], nrow: Int, ncol: Int) {
    this(Vector.tabulate(nrow, ncol){
      (r, c) => v(r * ncol + c)
    })
  }

  def shuffled() = {
    val shuffledVec = shuffle(vec.flatten)
    new Matrix(shuffledVec, this.nrow, this.ncol)
  }
}
