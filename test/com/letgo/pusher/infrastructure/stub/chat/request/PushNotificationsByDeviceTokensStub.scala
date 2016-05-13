package com.letgo.pusher.infrastructure.stub.chat.request

import play.api.libs.json.{JsArray, JsObject, JsString}

import com.letgo.pusher.domain.chat.Conversation.ConversationId
import com.letgo.pusher.domain.chat.Message.MessageText
import com.letgo.pusher.domain.chat.Talker.{TalkerId, TalkerName}
import com.letgo.pusher.domain.shared.Installation.Installation
import com.letgo.pusher.domain.shared.Product.ProductId
import com.letgo.pusher.domain.shared.RequestId
import com.letgo.pusher.infrastructure.stub.chat.domain.{ConversationIdStub, MessageTextStub, TalkerIdStub, TalkerNameStub}
import com.letgo.pusher.infrastructure.stub.shared.{InstallationStub, ProductIdStub, RequestIdStub}

object PushNotificationsByDeviceTokensStub {
  def create(
    requestId: RequestId = RequestIdStub.random,
    text: MessageText = MessageTextStub.random,
    conversationId: ConversationId = ConversationIdStub.random,
    productId: ProductId = ProductIdStub.random,
    talkerFromId: TalkerId = TalkerIdStub.random,
    talkerFromName: TalkerName = TalkerNameStub.random,
    talkerToId: TalkerId = TalkerIdStub.random,
    installations: Set[Installation] = InstallationStub.randomSet()
  ): JsObject = {
    JsObject(
      Seq(
        "data" -> JsObject(
          Seq(
            "type" -> JsString("message"),
            "id" -> JsString(requestId.value.toString),
            "attributes" -> JsObject(
              Seq(
                "text" -> JsString(text.value),
                "conversation_id" -> JsString(conversationId.value.toString),
                "product_id" -> JsString(productId.value),
                "from_talker_id" -> JsString(talkerFromId.value),
                "from_talker_public_username" -> JsString(talkerFromName.value),
                "to_talker_id" -> JsString(talkerToId.value)
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
