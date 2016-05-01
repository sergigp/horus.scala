package com.sergigp.horus.domain.model

import java.util.UUID

import scala.concurrent.Future

case class UserId(value: UUID)

case class UserName(value: String)

case class User(id: UserId, name: UserName)

trait UserRepository {
  def find(userId: UserId): Future[Option[User]]

  def create(user: User): Future[Int]

  def findByName(name: UserName): Future[Option[User]]
}
