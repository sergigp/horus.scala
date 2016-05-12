name := "pusher"

version := "1.0"

scalaVersion := "2.11.8"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies ++= Seq(
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.0" % "test",
  "org.scalamock" %% "scalamock-scalatest-support" % "3.2.2" % "test",
  "com.typesafe.play" %% "play-slick" % "1.1.1"
)

// Common commands aliases
addCommandAlias("t", "test")
addCommandAlias("to", "testOnly")
addCommandAlias("tq", "testQuick")
addCommandAlias("tsf", "testShowFailed")

addCommandAlias("c", "compile")
addCommandAlias("tc", "test:compile")

addCommandAlias("s", "scalastyle")
addCommandAlias("ts", "test:scalastyle")
