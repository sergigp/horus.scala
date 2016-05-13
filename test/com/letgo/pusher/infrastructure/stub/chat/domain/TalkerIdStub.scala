package com.letgo.pusher.infrastructure.stub.chat.domain

import java.util.UUID

import scala.util.Random

import com.letgo.pusher.domain.chat.Talker.TalkerId
import com.letgo.pusher.infrastructure.stub.StringStub

object TalkerIdStub {
  def create(id: String): TalkerId = new TalkerId(id)

  def random: TalkerId = {
    if (Random.nextBoolean) {
      create(UUID.randomUUID().toString)
    } else {
      create(StringStub.random(6))
    }
  }
}
