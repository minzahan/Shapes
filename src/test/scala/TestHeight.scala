package edu.luc.cs.laufer.cs372.shapes

import org.scalatest.FunSuite

import TestFixtures._

class TestHeight extends FunSuite {

  def testHeight(description: String, s: ShapeF, x: Int) = {
    test(description) {
      val y = height(s)
      assert(x === y)
    }
  }

  //counting the nested structures that are expected
  testHeight("simple ellipse", simpleEllipse, 1)
  testHeight("simple rectangle", simpleRectangle, 1)
  testHeight("simple location", simpleLocation, 2)
  testHeight("basic group", basicGroup, 2)
  testHeight("simple group", simpleGroup, 3)
  testHeight("complex group", complexGroup, 6)
}
