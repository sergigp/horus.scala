package com.sergigp.playms.infrastructure

import javax.inject.Inject

import scala.concurrent.Await
import scala.concurrent.duration._

import play.api.db.slick.DatabaseConfigProvider
import play.api.inject.Injector
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.libs.json.{JsObject, JsString}
import play.api.libs.ws.{WSClient, WSResponse}

import com.sergigp.playms.domain.model.{User, UserId, UserName, UserRepository}
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
    // @TODO truncate database
    EnvironmentArranger.cleanDatabase(injector)
  }

  val httpClient = app.injector.instanceOf[WSClient]
  val host       = s"localhost:$port"

  def userCreationUrl(userId: UserId) = s"http://$host/users/${userId.value.toString}"
  def userSearchUrl(userId: UserId) = s"http://$host/users/${userId.value.toString}"

  def httpCreateUserCall(userId: UserId, userName: UserName): WSResponse = {
    Await.result(httpClient.url(userCreationUrl(userId))
      .post(JsObject(Seq("user_name" -> JsString(userName.value)))), 5.seconds)
  }

  def httpSearchUserCall(userId: UserId): WSResponse = {
    Await.result(httpClient.url(userSearchUrl(userId))
        .get(), 5.seconds)
  }

  def httpCreateUserCallWithoutUserName(userId: UserId): WSResponse = {
    Await.result(httpClient.url(userCreationUrl(userId))
      .post(JsObject(Seq())), 5.seconds)
  }

  def createUser(user: User) = Await.result(userRepository.create(user), 5.seconds)

  private def userRepository: UserRepository = injector.instanceOf[UserRepository]
}
