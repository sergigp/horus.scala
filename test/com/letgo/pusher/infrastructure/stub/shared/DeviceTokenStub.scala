package com.letgo.pusher.infrastructure.stub.shared

import com.letgo.pusher.domain.shared.Installation.DeviceToken
import com.letgo.pusher.infrastructure.stub.StringStub

object DeviceTokenStub {
  def create(token: String = StringStub.random(60)): DeviceToken = DeviceToken(token)

  def random: DeviceToken = create()
}
