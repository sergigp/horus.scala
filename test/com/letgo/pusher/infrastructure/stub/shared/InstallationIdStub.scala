package com.letgo.pusher.infrastructure.stub.shared

import java.util.UUID

import com.letgo.pusher.domain.shared.Installation.InstallationId

object InstallationIdStub {
  def create(id: UUID = UUID.randomUUID()): InstallationId = InstallationId(id)

  def random: InstallationId = create()
}
