package com.letgo.pusher.infrastructure.stub.chat.domain

import com.letgo.pusher.domain.chat.Message.MessageText
import com.letgo.pusher.infrastructure.stub.StringStub


object MessageTextStub {
  def create(text: String = StringStub.random(10)): MessageText = new MessageText(text)

  def random: MessageText = create()

  def empty: MessageText = create("")
}
