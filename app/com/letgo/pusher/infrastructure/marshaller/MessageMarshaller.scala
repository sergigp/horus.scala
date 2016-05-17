package com.letgo.pusher.infrastructure.marshaller

import play.api.libs.json.{JsError, _}

import com.letgo.pusher.domain.chat.Message.MessageText


object MessageMarshaller {

  implicit val messageTextReads = new Reads[MessageText] {
    override def reads(json: JsValue): JsResult[MessageText] = json match {
      case JsString(text) => JsSuccess(MessageText(text))
      case _ => JsError("invalid message text")
    }
  }
}
