package com.letgo.pusher.infrastructure.stub.chat.request

import play.api.libs.json.{JsArray, JsNumber, JsObject, JsString}

import com.letgo.pusher.domain.chat.Conversation.ConversationId
import com.letgo.pusher.domain.chat.Message.MessageText
import com.letgo.pusher.domain.chat.Talker.{TalkerId, TalkerName}
import com.letgo.pusher.domain.shared.ClientNotification.UnreadClientNotificationCount
import com.letgo.pusher.domain.shared.Installation.Installation
import com.letgo.pusher.domain.shared.Notification.NotificationId
import com.letgo.pusher.domain.shared.Product.ProductId
import com.letgo.pusher.infrastructure.stub.chat.domain.{ConversationIdStub, MessageTextStub, TalkerIdStub, TalkerNameStub}
import com.letgo.pusher.infrastructure.stub.shared.{InstallationStub, NotificationIdStub, ProductIdStub, UnreadClientNotificationCountStub}

object PushNotificationsByDeviceTokensStub {
  def create(
    notificationId: NotificationId = NotificationIdStub.random,
    text: MessageText = MessageTextStub.random,
    conversationId: ConversationId = ConversationIdStub.random,
    productId: ProductId = ProductIdStub.random,
    talkerFromId: TalkerId = TalkerIdStub.random,
    talkerFromName: TalkerName = TalkerNameStub.random,
    talkerToId: TalkerId = TalkerIdStub.random,
    installations: Set[Installation] = InstallationStub.randomSet(),
    unreadClientNotificationCount: UnreadClientNotificationCount = UnreadClientNotificationCountStub.random
  ): JsObject = {
    JsObject(
      Seq(
        "data" -> JsObject(
          Seq(
            "type" -> JsString("message"),
            "id" -> JsString(notificationId.value.toString),
            "attributes" -> JsObject(
              Seq(
                "text" -> JsString(text.value),
                "conversation_id" -> JsString(conversationId.value.toString),
                "product_id" -> JsString(productId.value),
                "from_talker_id" -> JsString(talkerFromId.value),
                "from_talker_public_username" -> JsString(talkerFromName.value),
                "to_talker_id" -> JsString(talkerToId.value),
                "unread_notifications_count" -> JsNumber(unreadClientNotificationCount.value)
              )
            ),
            "relationships" -> JsObject(
              Seq(
                "installations" -> JsArray(
                  installations.map { installation =>
                    JsObject(
                      Seq(
                        "data" -> JsObject(
                          Seq(
                            "type" -> JsString("installation"),
                            "id" -> JsString(installation.id.value.toString),
                            "attributes" -> JsObject(
                              Seq(
                                "device_token" -> JsString(installation.deviceToken.value)
                              )
                            )
                          )
                        )
                      )
                    )
                  }.toSeq // parenthesis hell
                )
              )
            )
          )
        )
      )
    )
  }

  def random: JsObject = create()
}
