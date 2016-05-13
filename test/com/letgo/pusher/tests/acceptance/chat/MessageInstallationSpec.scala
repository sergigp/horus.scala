package com.letgo.pusher.tests.acceptance.chat

import com.letgo.pusher.infrastructure.AcceptanceSpec
import com.letgo.pusher.infrastructure.stub.chat.request.PushNotificationsByDeviceTokensStub

class MessageInstallationSpec extends AcceptanceSpec {
  "Pusher" should {

    "send a push notification to a single device token" in {
      val response = httpCreatePushNotificationByDeviceTokens(
        PushNotificationsByDeviceTokensStub.random
      )

      response.status shouldBe 201
    }

//    "send a push notification to multiple device tokens" in {
//
//    }
  }
}
