package edu.luc.cs.laufer.cs372.shapes

// TODO: implement this behavior

object boundingBox {
  def apply(s: Shape): Location = s match {
    case Rectangle(w, h) => Location(0, 0, new Rectangle(w, h))
    case Ellipse(r, r2)  => Location(-r, -r2, Rectangle(r * 2, r2 * 2))
    case Location(x, y, shape) => {
      val boundedShape = boundingBox(shape)
      val rectangleOfBoundedShape = boundedShape.shape
      val height = rectangleOfBoundedShape.asInstanceOf[Rectangle].height
      val width = rectangleOfBoundedShape.asInstanceOf[Rectangle].width
      val innerX = boundedShape.x
      val innerY = boundedShape.y
      val trueX = x + innerX
      val trueY = y + innerY
      Location(trueX, trueY, Rectangle(width, height))
    }
    case Group(shapes @ _*) =>
      val boundedShape = shapes.map(shape => boundingBox(shape))
      val seqXs = boundedShape.map(bs => bs.x)
      val seqYs = boundedShape.map(bs => bs.y)
      //      val seqWidths = boundedShape.map(bs => bs.shape.asInstanceOf[Rectangle].width)
      //      val seqHeights = boundedShape.map(bs => bs.shape.asInstanceOf[Rectangle].height)

      val minX = seqXs.min
      val minY = seqYs.min

      val maxX = boundedShape.map(bs => bs.x + bs.shape.asInstanceOf[Rectangle].width - minX).max
      val maxY = boundedShape.map(bs => bs.y + bs.shape.asInstanceOf[Rectangle].height - minY).max

      Location(minX, minY, Rectangle(maxX, maxY))

  }
}

