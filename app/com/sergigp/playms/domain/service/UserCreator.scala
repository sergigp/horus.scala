package com.sergigp.playms.domain.service

import javax.inject.Inject

import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.Future

import com.sergigp.playms.domain.model.{User, UserId, UserName, UserRepository}

class UserCreator @Inject()(userRepository: UserRepository) {

  def create(userId: UserId, name: UserName): Future[Option[User]] = {

    userRepository.findByName(name).flatMap {
      case Some(existingUser) => Future.successful(None)
      case None =>
        val user = User(userId, name)
        userRepository.create(user).map { _ =>
          Some(user)
        }
    }
  }
}
