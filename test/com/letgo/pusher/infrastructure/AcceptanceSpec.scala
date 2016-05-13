package com.letgo.pusher.infrastructure

import scala.concurrent.Await
import scala.concurrent.duration._

import play.api.inject.Injector
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.libs.json.JsObject
import play.api.libs.ws.{WSClient, WSResponse}

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

  val pushNotificationsByDeviceTokensUrl = s"http://$host/chat/message/installation"

  def httpCreatePushNotificationByDeviceTokens(postBody: JsObject): WSResponse = {
    Await.result(
      httpClient.url(pushNotificationsByDeviceTokensUrl).post(postBody),
      5.seconds
    )
  }
}
