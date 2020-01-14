package Boggle

import scala.util.Random.shuffle
import scala.io.Source

import scala.scalajs.js
// import org.scalajs.dom
import js.JSConverters._

object Helper {
  def isSquare(n: Int): Boolean = math.sqrt(n).isWhole

  def readLinesFromResourceDir(fpath: String): List[String] = {
    return Source.fromResource(fpath).getLines().toList
  }

  val defaultDice: js.Array[Die] = {
    // val lines = Helper.readLinesFromResourceDir("/dice.txt")
    // val dice = lines.map(line => Die(line.toUpperCase.split(",").toJSArray))
    // dice.toJSArray
    
    Array.fill(16)(Die(js.Array("A", "B", "N"))).toJSArray

    // val diceConfig = """
    //   A,A,E,E,G,N
    //   A,B,B,J,O,O
    //   A,C,H,O,P,S
    //   A,F,F,K,P,S
    //   A,O,O,T,T,W
    //   C,I,M,O,T,U
    //   D,E,I,L,R,X
    //   D,E,L,R,V,Y
    //   D,I,S,T,T,Y
    //   E,E,G,H,N,W
    //   E,E,I,N,S,U
    //   E,H,R,T,V,W
    //   E,I,O,S,S,T
    //   E,L,R,T,T,Y
    //   H,I,M,N,U,Qu
    //   H,L,N,N,R,Z
    //   """

    // diceConfig.trim
    //           .split("\n")
    //           .map(letters => Die(letters.trim.split(",").toJSArray))
    //           .toJSArray
  }

  val defaultDict: js.Array[String] = {
    // Helper.readLinesFromResourceDir("/dict.txt").toJSArray
    js.Array("BAN", "NAB", "ANN", "CAN", "BANANA")
  }
}

