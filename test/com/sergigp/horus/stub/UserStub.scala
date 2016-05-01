package com.sergigp.horus.stub

import com.sergigp.horus.domain.model.{User, UserId, UserName}

object UserStub {
  def create(id: UserId = UserIdStub.random, name: UserName = UserNameStub.random): User = {
    User(id, name)
  }

  def random: User = create()
}
