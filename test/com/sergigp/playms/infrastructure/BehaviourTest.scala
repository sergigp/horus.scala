package com.sergigp.playms.infrastructure

import scala.concurrent.Future

import com.sergigp.playms.domain.model.{User, UserId, UserName, UserRepository}
import org.scalamock.scalatest.MockFactory
import org.scalatest._
import org.scalatest.concurrent.ScalaFutures

class BehaviourTest extends WordSpec
  with Matchers
  with OptionValues
  with ScalaFutures
  with MockFactory
  with BeforeAndAfterEach {

  var userRepository: UserRepository = _

  override def beforeEach() {
    userRepository = mock[UserRepository]
  }

  def shouldCreateUser(user: User) = {
    (userRepository.create _).expects(user).returning(Future.successful(1))
  }

  def shouldFindUser(userId: UserId, existingUser: Option[User]) = {
    (userRepository.find _).expects(userId).returning(Future.successful(existingUser))
  }

  def shouldNotCreateUser() = {
    (userRepository.create _).expects(*).never()
  }

  def shouldFindUserByName(userName: UserName, existingUser: Option[User]) = {
    (userRepository.findByName _).expects(userName).returning(Future.successful(existingUser))
  }
}
