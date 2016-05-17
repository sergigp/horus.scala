package com.letgo.pusher.tests.acceptance.chat

import play.api.libs.json.{JsArray, JsObject, JsString}

import com.letgo.pusher.infrastructure.AcceptanceSpec
import com.letgo.pusher.infrastructure.stub.chat.request.PushNotificationsByDeviceTokensStub
import com.letgo.pusher.infrastructure.stub.shared.{InstallationStub, NotificationIdStub}

class MessageInstallationSpec extends AcceptanceSpec {
  "Pusher" should {

    "send a push notification to a single device token" in {
      val response = httpCreatePushNotificationByDeviceTokens(
        PushNotificationsByDeviceTokensStub.random
      )

      response.status shouldBe 201
    }

    "return error when not passing mandatory arguments" in {
      val response = httpCreatePushNotificationByDeviceTokens(JsObject(Seq.empty))

      response.status shouldBe 400
    }

    "return error is passing not correctly formatted data" in {
      val badRequest = JsObject(
        Seq(
          "data" -> JsObject(
            Seq(
              "type" -> JsString("message"),
              "id" -> JsString("patata"),
              "attributes" -> JsObject(
                Seq(
                  "text" -> JsString("aaaa"),
                  "conversation_id" -> JsString("bbbb"),
                  "product_id" -> JsString("123"),
                  "from_talker_id" -> JsString("123"),
                  "from_talker_public_username" -> JsString("patata"),
                  "to_talker_id" -> JsString("123"),
                  "unread_notifications_count" -> JsString("abc")
                )
              )
//              "relationships" -> JsObject(
//                Seq(
//                  "installations" -> JsArray(
//                    InstallationStub.randomSet().map { installation =>
//                      JsObject(
//                        Seq(
//                          "data" -> JsObject(
//                            Seq(
//                              "type" -> JsString("installation"),
//                              "id" -> JsString("zzz"),
//                              "attributes" -> JsObject(
//                                Seq(
//                                  "device_token" -> JsString(installation.deviceToken.value)
//                                )
//                              )
//                            )
//                          )
//                        )
//                      )
//                    }.toSeq
//                  )
//                )
//              )
            )
          )
        )
      )
      val response = httpCreatePushNotificationByDeviceTokens(badRequest)

      response.status shouldBe 400
    }
  }
}
