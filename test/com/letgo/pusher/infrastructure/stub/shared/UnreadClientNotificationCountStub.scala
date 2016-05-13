package com.letgo.pusher.infrastructure.stub.shared

import scala.util.Random

import com.letgo.pusher.domain.shared.ClientNotification.UnreadClientNotificationCount

object UnreadClientNotificationCountStub {
  def create(number: Int = Random.nextInt(10)): UnreadClientNotificationCount = {
    UnreadClientNotificationCount(number)
  }

  def random: UnreadClientNotificationCount = create()
}
