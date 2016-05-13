package com.letgo.pusher.infrastructure.stub.chat.domain

import com.letgo.pusher.domain.chat.Talker.TalkerName
import com.letgo.pusher.infrastructure.stub.StringStub

object TalkerNameStub {
  def create(name: String = StringStub.random(10)): TalkerName = TalkerName(name)

  def random: TalkerName = create()
}
