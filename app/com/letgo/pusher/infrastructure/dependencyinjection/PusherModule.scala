package com.letgo.pusher.infrastructure.dependencyinjection

import play.api.{Configuration, Environment}
import play.api.libs.concurrent.AkkaGuiceSupport

import com.google.inject.AbstractModule
import net.codingwell.scalaguice.ScalaModule

import com.letgo.pusher.infrastructure.cqrs.{CommandBus, CommandBusActor}


class PusherModule(
  environment: Environment,
  configuration: Configuration
) extends AbstractModule with AkkaGuiceSupport with ScalaModule {
  override def configure(): Unit = {
    bindActor[CommandBusActor](CommandBusActor.name)

    bind[CommandBus].to[CommandBusActor]
  }
}
