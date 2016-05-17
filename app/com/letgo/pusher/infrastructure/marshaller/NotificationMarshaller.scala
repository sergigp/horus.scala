package com.letgo.pusher.infrastructure.marshaller

import java.util.UUID

import play.api.libs.json.{JsError, _}

import com.letgo.pusher.domain.shared.Notification.NotificationId

object NotificationMarshaller {
  implicit val notificationIdReads = new Reads[NotificationId] {
    override def reads(json: JsValue): JsResult[NotificationId] = json match {
      case JsString(id) => JsSuccess(NotificationId(UUID.fromString(id)))
      case _ => JsError("invalid notification id")
    }
  }
}
