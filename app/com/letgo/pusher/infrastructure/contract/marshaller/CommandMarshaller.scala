package com.letgo.pusher.infrastructure.contract.marshaller

import play.api.libs.functional.syntax._
import play.api.libs.json.{JsPath, Reads}

import com.letgo.pusher.contract.commands.MessageNotificationByInstallationsCommand
import com.letgo.pusher.domain.chat.Conversation.ConversationId
import com.letgo.pusher.domain.chat.Message.MessageText
import com.letgo.pusher.domain.chat.Talker.{TalkerId, TalkerName}
import com.letgo.pusher.domain.shared.ClientNotification.UnreadClientNotificationCount
import com.letgo.pusher.domain.shared.Installation.Installation
import com.letgo.pusher.domain.shared.Notification.NotificationId
import com.letgo.pusher.domain.shared.Product.ProductId
import com.letgo.pusher.infrastructure.marshaller.ClientNotificationMarshaller._
import com.letgo.pusher.infrastructure.marshaller.ConversationMarshaller._
import com.letgo.pusher.infrastructure.marshaller.InstallationMarshaller._
import com.letgo.pusher.infrastructure.marshaller.MessageMarshaller._
import com.letgo.pusher.infrastructure.marshaller.NotificationMarshaller._
import com.letgo.pusher.infrastructure.marshaller.ProductMarshaller._
import com.letgo.pusher.infrastructure.marshaller.TalkerMarshaller._

object CommandMarshaller {

  implicit val pushByInstallationRequestReads: Reads[MessageNotificationByInstallationsCommand] = (
    (JsPath \ "data" \ "id").read[NotificationId] and
    (JsPath \ "data" \ "attributes" \ "conversation_id").read[ConversationId] and
    (JsPath \ "data" \ "attributes" \ "text").read[MessageText] and
    (JsPath \ "data" \ "attributes" \ "product_id").read[ProductId] and
    (JsPath \ "data" \ "attributes" \ "from_talker_id").read[TalkerId] and
    (JsPath \ "data" \ "attributes" \ "from_talker_public_username").read[TalkerName] and
    (JsPath \ "data" \ "attributes" \ "to_talker_id").read[TalkerId] and
    (JsPath \ "data" \ "attributes" \ "unread_notifications_count").read[UnreadClientNotificationCount] and
    (JsPath \ "data" \ "relationships" \ "installations").read[Seq[Installation]]
    ) (MessageNotificationByInstallationsCommand.apply _)
}
