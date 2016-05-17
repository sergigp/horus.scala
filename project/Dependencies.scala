import sbt._

object Dependencies {

  object Production {
    val logback       = "ch.qos.logback" % "logback-classic" % "1.1.3"
    val logstash      = "net.logstash.logback" % "logstash-logback-encoder" % "4.6"
    val aspectjweaver = "org.aspectj" % "aspectjweaver" % "1.8.7"
    val guice         = "com.google.inject" % "guice" % "4.0"
    val scalaGuice    = "net.codingwell" %% "scala-guice" % "4.0.1"
  }

  object Testing {
    val scalatestplusPlay = "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.0" % Test
    val scalamock         = "org.scalamock" %% "scalamock-scalatest-support" % "3.2.2" % Test
    val pprint            = "com.lihaoyi" %% "pprint" % "0.4.0"
  }

}
