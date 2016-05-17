package com.letgo.pusher.contract.commands

import com.letgo.pusher.domain.chat.Conversation.ConversationId
import com.letgo.pusher.domain.chat.Message.MessageText
import com.letgo.pusher.domain.chat.Talker.{TalkerId, TalkerName}
import com.letgo.pusher.domain.shared.ClientNotification.UnreadClientNotificationCount
import com.letgo.pusher.domain.shared.Installation.Installation
import com.letgo.pusher.domain.shared.Notification.NotificationId
import com.letgo.pusher.domain.shared.Product.ProductId
import com.letgo.pusher.infrastructure.cqrs.Command

case class MessageNotificationByInstallationsCommand(
  notificationId: NotificationId,
  conversationId: ConversationId,
  messageText: MessageText,
  productId: ProductId,
  fromTalkerId: TalkerId,
  fromTalkerName: TalkerName,
  toTalkerId: TalkerId,
  unreadNotificationsCount: UnreadClientNotificationCount,
  installations: Seq[Installation]
) extends Command
