package com.sergigp.playms.infrastructure.dependencyinjection

import play.api.{Configuration, Environment}

import com.google.inject.AbstractModule
import com.sergigp.playms.domain.model.UserRepository
import com.sergigp.playms.infrastructure.persistence.UserRepositoryMySql

class PlaymsModule(environment: Environment, configuration: Configuration) extends AbstractModule {
  override def configure(): Unit = {
    bind(classOf[UserRepository]).to(classOf[UserRepositoryMySql])
  }
}
