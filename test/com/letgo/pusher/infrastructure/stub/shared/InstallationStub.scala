package com.letgo.pusher.infrastructure.stub.shared

import com.letgo.pusher.domain.shared.Installation.{DeviceToken, Installation, InstallationId}

object InstallationStub {
  def create(
    id: InstallationId = InstallationIdStub.random,
    deviceToken: DeviceToken = DeviceTokenStub.random
  ): Installation = {
    Installation(id, deviceToken)
  }

  def random: Installation = create()

  def randomSet(numElements: Int = 3): Set[Installation] = {
    (1 to numElements).map(_ => create()).toSet
  }
}
