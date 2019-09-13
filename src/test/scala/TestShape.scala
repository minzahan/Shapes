package edu.luc.cs.laufer.cs372.shapes

import org.scalatest.FunSuite

class TestShape extends FunSuite {

  test("Illegal Rectangle") {
    intercept[IllegalArgumentException](new Rectangle(-20, -40))

  }

  test("Illegal Ellipse") {
    intercept[IllegalArgumentException](new Ellipse(-50, -30))
  }

  test("Illegal Group") {
    intercept[IllegalArgumentException](new Group(null))
  }

  test("Illegal Location") {
    intercept[IllegalArgumentException](new Location(-20, -40, null))
  }
}

