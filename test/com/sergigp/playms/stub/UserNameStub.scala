package com.sergigp.playms.stub

import com.sergigp.playms.domain.model.UserName
import com.sergigp.playms.infrastructure.StringStub

object UserNameStub {
  def create(name: String = StringStub.random(6)): UserName = UserName(name)

  def random = create()
}
