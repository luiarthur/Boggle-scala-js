package Boggle

import scala.util.Random.{shuffle => scalaShuffle}
import scala.reflect.ClassTag

case class Matrix[T: ClassTag](arr: Array[Array[T]]){
  val nrow = arr.size
  val ncol = arr(0).size
  val nelem = nrow * ncol
  arr.foreach(row => require(row.size == ncol))

  def apply(x: Int, y: Int): T = arr(x)(y)

  def update(x: Int, y: Int, value: T): Unit = {
    arr(x)(y) = value
  }

  override def toString() = {
    arr.map(row => row.map(x => f"$x%2s").mkString(" ")).mkString("\n")
  }

  def shuffle() {
    val shuffledVec = scalaShuffle(arr.map(_.toList).toList.flatten)
    for(r <- 0 until nrow; c <- 0 until ncol) {
      this(r, c) = shuffledVec(r * ncol + c)
    }
  }

  def this(a: Array[T], nrow: Int, ncol: Int) {
    this(Array.tabulate(nrow, ncol){
      (r, c) => a(r * ncol + c)
    })
  }
}
