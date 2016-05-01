package com.sergigp.playms.domain.service

import javax.inject.Inject

import scala.concurrent.Future

import com.sergigp.playms.domain.model.{User, UserId, UserRepository}

class UserSearcher @Inject()(userRepository: UserRepository) {

  def search(userId: UserId): Future[Option[User]] = {
    userRepository.find(userId)
  }
}
