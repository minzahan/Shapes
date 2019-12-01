package edu.luc.cs.laufer.cs372.shapes

object scale {
  def apply(s: ShapeF, factor: Int): ShapeF = s match {
    case Rectangle(w, h)       => Rectangle(factor * w, factor * h)
    case Ellipse(r, r2)        => Ellipse(factor * r, factor * r2)
    case Location(x, y, shape) => Location(x * factor, y * factor, scale(shape, factor))
    case Group(shapes @ _*)    => Group(shapes.map(shape => scale(shape, factor)): _*)
  }
}
