package com.sergigp.horus.infrastructure.dependencyinjection

import play.api.{Configuration, Environment}

import com.google.inject.AbstractModule
import com.sergigp.horus.domain.model.UserRepository
import com.sergigp.horus.infrastructure.persistence.UserRepositoryMySql

class HorusModule(environment: Environment, configuration: Configuration) extends AbstractModule {
  override def configure(): Unit = {
    bind(classOf[UserRepository]).to(classOf[UserRepositoryMySql])
  }
}
