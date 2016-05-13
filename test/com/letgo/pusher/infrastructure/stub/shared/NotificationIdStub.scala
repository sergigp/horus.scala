package com.letgo.pusher.infrastructure.stub.shared

import java.util.UUID

import com.letgo.pusher.domain.shared.Notification.NotificationId

object NotificationIdStub {
  def create(id: UUID = UUID.randomUUID()): NotificationId = new NotificationId(id)

  def fromString(id: String): NotificationId = create(UUID.fromString(id))

  def random: NotificationId = create()
}
