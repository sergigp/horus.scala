package com.letgo.pusher.infrastructure.stub.chat.domain

import java.util.UUID

import com.letgo.pusher.domain.chat.Conversation.ConversationId

object ConversationIdStub {

  def create(id: UUID = UUID.randomUUID()): ConversationId = ConversationId(id)

  def fromString(id: String): ConversationId = create(UUID.fromString(id))

  def random: ConversationId = create()
}
