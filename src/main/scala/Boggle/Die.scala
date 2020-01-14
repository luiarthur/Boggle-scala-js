package Boggle

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}
import scala.scalajs.js
import scala.util.Random

@JSExportTopLevel("Die")
case class Die(faces: js.Array[String]) {
  val numFaces = faces.size

  def roll(): String = {
    val idx = Random.nextInt(numFaces)
    return faces(idx)
  }
}
