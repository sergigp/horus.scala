package com.letgo.pusher.infrastructure.marshaller

import java.util.UUID

import play.api.libs.json.{JsError, _}

import com.letgo.pusher.domain.chat.Conversation.ConversationId

object ConversationMarshaller {
  implicit val conversationIdReads = new Reads[ConversationId] {
    override def reads(json: JsValue): JsResult[ConversationId] = json match {
      case JsString(cId) => JsSuccess(ConversationId(UUID.fromString(cId)))
      case _ => JsError("invalid conversation id")
    }
  }
}
