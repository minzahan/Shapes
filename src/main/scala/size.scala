package edu.luc.cs.laufer.cs372.shapes

object size {
  def apply(s: Shape): Int = s match {
    case Rectangle(w, h)       => 1
    case Ellipse(r, r2)        => 1
    case Location(x, y, shape) => size(shape)
    case Group(shapes @ _*) =>
      shapes.map { shape => size(shape) }.sum
  }
}
