package com.letgo.pusher.infrastructure.dependencyinjection

import play.api.{Configuration, Environment}

import com.google.inject.AbstractModule


class PusherModule(environment: Environment, configuration: Configuration) extends AbstractModule {
  override def configure(): Unit = {
  }
}
