package com.sergigp.playms.stub

import java.util.UUID

import com.sergigp.playms.domain.model.UserId

object UserIdStub {
  def create(id: UUID = UUID.randomUUID()): UserId = UserId(id)

  def random = create()
}
