package edu.luc.cs.laufer.cs372.shapes

/**
  * data Shape = Rectangle(w, h) | Location(x, y, Shape)
  */
sealed trait Shape

case class Group(shapes: Shape*) extends Shape {
  require(shapes != null, "there are no shapes in group")
}

case class Ellipse(radius: Int, radius2: Int) extends Shape {
  require(radius > 0 && radius2 > 0, "can't have negative axis for ellipse")
}

case class Rectangle(width: Int, height: Int) extends Shape {
  require(width > 0 && height > 0, "the width and height of a rectangle can't be negative numbers")
}

case class Location(x: Int, y: Int, shape: Shape) extends Shape {
  require(shape != null, "null shape in location")
}

//requires: all cant be null and all must be greater than 0
// TODO add missing case classes (see test fixtures)
// TODO must include validity checking for constructor arguments
