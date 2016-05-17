/** *****************************************/
/** ********* PROJECT INFO ******************/
/** *****************************************/
name := "pusher"
version := "1.0"

/** *********************************************/
/** ********* PROJECT SETTINGS ******************/
/** *********************************************/
lazy val root = (project in file(".")).enablePlugins(PlayScala)

/** *****************************************/
/** ********* DEPENDENCIES ******************/
/** *****************************************/
scalaVersion := "2.11.8"

// Resolvers
resolvers += Resolver.bintrayRepo("dwhjames", "maven") // awsWrap

libraryDependencies ++= Seq(
  Dependencies.Production.logback,
  Dependencies.Production.logstash,
  Dependencies.Production.aspectjweaver,
  Dependencies.Production.guice,
  Dependencies.Production.scalaGuice,

  Dependencies.Testing.scalatestplusPlay,
  Dependencies.Testing.scalamock,
  Dependencies.Testing.pprint
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
