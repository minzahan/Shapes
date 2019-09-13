package edu.luc.cs.laufer.cs372.shapes

object height {
  def apply(s: Shape): Int = s match {
    case Rectangle(w, h)       => 1
    case Ellipse(r, r2)        => 1
    case Location(x, y, shape) => 1 + height(shape)
    case Group(shapes @ _*) =>
      1 + shapes.map { shape => height(shape) }.max
  }
}
