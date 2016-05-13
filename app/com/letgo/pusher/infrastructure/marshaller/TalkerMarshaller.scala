package com.letgo.pusher.infrastructure.marshaller

import play.api.libs.json.{JsError, _}

import com.letgo.pusher.domain.chat.Talker.{TalkerId, TalkerName}

object TalkerMarshaller {

  implicit val talkerIdReads = new Reads[TalkerId] {
    override def reads(json: JsValue): JsResult[TalkerId] = json match {
      case JsString(id) => JsSuccess(TalkerId(id))
      case _ => JsError("invalid talker id")
    }
  }

  implicit val talkerNameReads = new Reads[TalkerName] {
    override def reads(json: JsValue): JsResult[TalkerName] = json match {
      case JsString(name) => JsSuccess(TalkerName(name))
      case _ => JsError("invalid talker name")
    }
  }
}
