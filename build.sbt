name := "shapes-oo-scala"

version := "0.2"

scalaVersion := "2.12.9"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked")

libraryDependencies ++= Seq(
  "com.slamdata" %% "matryoshka-core" % "0.21.3",
  "org.scalaz" %% "scalaz-core" % "7.2.29",
  "org.scalatest"  %% "scalatest"  % "3.0.5"  % Test,
  "org.scalacheck" %% "scalacheck" % "1.14.0" % Test,
  "com.slamdata" %% "matryoshka-scalacheck" % "0.21.3" % Test
)
