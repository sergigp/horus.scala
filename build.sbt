name := "pusher"

version := "1.0"

scalaVersion := "2.11.8"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies ++= Seq(
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.0" % "test",
  "org.scalamock" %% "scalamock-scalatest-support" % "3.2.2" % "test",
  "ch.qos.logback" % "logback-classic" % "1.1.3",
  "net.logstash.logback" % "logstash-logback-encoder" % "4.6",
  "org.aspectj" % "aspectjweaver" % "1.8.7"
  // @TODO Kamon
)

// Common commands aliases
addCommandAlias("t", "test")
addCommandAlias("to", "testOnly")
addCommandAlias("ta", "testOnly com.letgo.pusher.tests.acceptance.*")
addCommandAlias("tb", "testOnly com.letgo.pusher.tests.behaviour.*")
addCommandAlias("ti", "testOnly com.letgo.pusher.tests.infrastructure.*")
addCommandAlias("tq", "testQuick")
addCommandAlias("tsf", "testShowFailed")

addCommandAlias("c", "compile")
addCommandAlias("tc", "test:compile")

addCommandAlias("s", "scalastyle")
addCommandAlias("ts", "test:scalastyle")
