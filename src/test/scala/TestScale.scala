package edu.luc.cs.laufer.cs372.shapes

import org.scalatest.FunSuite

import TestFixtures._

class TestScale extends FunSuite {

  def testScale(description: String, s: ShapeF, factor: Int, sc: ShapeF) = {
    test(description) {
      val originalShape = scale(s, factor)
      assert(originalShape === sc)

    }
  }

  // TODO comment these tests back in

  testScale("simple ellipse", simpleEllipse, 2, simpleScaledEllipse)
  testScale("simple rectangle", simpleRectangle, 2, simpleScaledRectangle)
  testScale("simple location", simpleLocation, 2, simpleScaledLocation)
  testScale("basic group", basicGroup, 2, basicScaledGroup)
  testScale("simple group", simpleGroup, 2, simpleScaledGroup)
  testScale("complex group", complexGroup, 2, complexScaledGroup)
}
