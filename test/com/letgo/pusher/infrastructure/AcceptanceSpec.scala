package com.letgo.pusher.infrastructure

import play.api.inject.Injector
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.libs.ws.WSClient

import org.scalatest.{BeforeAndAfterEach, Matchers, WordSpec}
import org.scalatestplus.play.{OneServerPerSuite, WsScalaTestClient}

class AcceptanceSpec extends WordSpec
  with WsScalaTestClient
  with Matchers
  with OneServerPerSuite
  with BeforeAndAfterEach {

  var injector: Injector = _

  override def beforeEach() {
    injector = new GuiceApplicationBuilder().injector
  }

  val httpClient = app.injector.instanceOf[WSClient]
  val host       = s"localhost:$port"
}
