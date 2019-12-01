package edu.luc.cs.laufer.cs372.shapes

import matryoshka.data.Fix
import scalaz.Functor

/**
  * data Shape = Rectangle(w, h) | Location(x, y, Shape)
  */
object structure {

  sealed trait ShapeF[A]

  case class Group[A](shapes: ShapeF[A]*) extends ShapeF[A] {
    require(shapes != null, "there are no shapes in group")
  }

  case class Ellipse[A](radius: Int, radius2: Int) extends ShapeF[A] {
    require(radius > 0 && radius2 > 0, "can't have negative axis for ellipse")
  }

  case class Rectangle[A](width: Int, height: Int) extends ShapeF[A] {
    require(width > 0 && height > 0, "the width and height of a rectangle can't be negative numbers")
  }

  case class Location[A](x: Int, y: Int, shape: ShapeF[A]) extends ShapeF[A] {
    require(shape != null, "null shape in location")
  }

  object shapeFFunctor extends Functor[ShapeF] {
    override def map[A, B](fa: ShapeF[A])(f: A => B): ShapeF[B] = fa match {
      case Rectangle(w, h) => Rectangle[B](w, h)
      case Ellipse(r, r2) => Ellipse[B](r, r2)
      case Location(x, y, s) => Location[B](x, y, map(s)(f))
      case Group(shapes@_*) => Group[B](shapes.map(shape => map(shape)(f)): _*)
    }
  }

  type Shape = Fix[ShapeF]

}

//requires: all cant be null and all must be greater than 0
// TODO add missing case classes (see test fixtures)
// TODO must include validity checking for constructor arguments
