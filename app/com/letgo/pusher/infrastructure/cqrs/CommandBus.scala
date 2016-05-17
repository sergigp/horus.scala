package com.letgo.pusher.infrastructure.cqrs

trait Command

trait CommandBus {
  def publish(command: Command)
}
