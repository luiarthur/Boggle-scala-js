package Boggle

case class Coord(x: Int, y: Int) {
  def +(that: Coord): Coord = {
    return Coord(this.x + that.x, this.y + that.y)
  }

  def ==(that: Coord): Boolean = {
    return (this.x == that.x) && (this.y == that.y)
  }
}
