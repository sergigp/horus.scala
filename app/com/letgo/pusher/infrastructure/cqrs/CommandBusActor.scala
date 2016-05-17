package com.letgo.pusher.infrastructure.cqrs

import javax.inject.{Inject, Singleton}

import akka.actor.{Actor, ActorLogging}

import com.letgo.pusher.contract.commands.MessageNotificationByInstallationsCommand
import com.letgo.pusher.domain.chat.MessageNotificationSenderByDeviceTokens

object CommandBusActor {
  val name = "command-bus"
}

@Singleton
class CommandBusActor @Inject()(
  messageNotificationSenderByDeviceTokens: MessageNotificationSenderByDeviceTokens
) extends Actor with CommandBus with ActorLogging {

  override def publish(command: Command): Unit = receive(command)

  override def receive: Receive = {
    case command: MessageNotificationByInstallationsCommand =>
      messageNotificationSenderByDeviceTokens.send(
        command.notificationId,
        command.conversationId,
        command.messageText,
        command.productId,
        command.fromTalkerId,
        command.fromTalkerName,
        command.toTalkerId,
        command.unreadNotificationsCount,
        command.installations
      )
  }

}
