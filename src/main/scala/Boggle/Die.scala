package Boggle

import scala.util.Random

case class Die(faces: Vector[String]) {
  val numFaces = faces.size

  def roll(): String = {
    val idx = Random.nextInt(numFaces)
    return faces(idx)
  }
}
