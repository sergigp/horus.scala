package com.letgo.pusher.infrastructure

import play.api.inject.Injector
import play.api.inject.guice.GuiceApplicationBuilder

import org.scalatest._
import org.scalatest.concurrent.ScalaFutures

class InfrastructureTest extends WordSpec
  with Matchers
  with OptionValues
  with ScalaFutures
  with BeforeAndAfterEach {

  var injector: Injector = _

  override def beforeEach() {
    injector = new GuiceApplicationBuilder().injector
  }
}
