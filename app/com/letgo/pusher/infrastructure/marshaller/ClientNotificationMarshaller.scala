package com.letgo.pusher.infrastructure.marshaller

import play.api.libs.json.{JsError, _}

import com.letgo.pusher.domain.shared.ClientNotification.UnreadClientNotificationCount

object ClientNotificationMarshaller {
  implicit val unreadClientnotificationsCountReads = new Reads[UnreadClientNotificationCount] {
    override def reads(json: JsValue): JsResult[UnreadClientNotificationCount] = json match {
      case JsNumber(count) => JsSuccess(UnreadClientNotificationCount(count.toInt))
      case _ => JsError("invalid unread notifications count")
    }
  }
}
