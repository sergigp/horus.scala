package com.letgo.pusher.domain.shared

import java.util.UUID

object Installation {
  case class InstallationId(value: UUID)

  case class DeviceToken(value: String)

  case class Installation(id: InstallationId, deviceToken: DeviceToken)
}
