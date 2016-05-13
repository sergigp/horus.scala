package com.letgo.pusher.infrastructure.stub.shared

import java.util.UUID

import com.letgo.pusher.domain.shared.RequestId

object RequestIdStub {
  def create(id: UUID = UUID.randomUUID()): RequestId = new RequestId(id)

  def fromString(id: String): RequestId = create(UUID.fromString(id))

  def random: RequestId = create()
}
