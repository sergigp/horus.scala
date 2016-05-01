package com.sergigp.playms.stub

import com.sergigp.playms.domain.model.{User, UserId, UserName}

object UserStub {
  def create(id: UserId = UserIdStub.random, name: UserName = UserNameStub.random): User = {
    User(id, name)
  }

  def random: User = create()
}
