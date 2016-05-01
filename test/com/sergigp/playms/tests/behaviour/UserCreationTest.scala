package com.sergigp.playms.tests.behaviour

import com.sergigp.playms.domain.service.UserCreator
import com.sergigp.playms.infrastructure.BehaviourTest
import com.sergigp.playms.stub.{UserIdStub, UserNameStub, UserStub}

class UserCreationTest extends BehaviourTest {

  def userCreator = new UserCreator(userRepository)

  "User Creator" should {
    "register new users" in {
      val userId = UserIdStub.random
      val userName = UserNameStub.random
      val expectedUser = UserStub.create(userId, userName)

      shouldFindUserByName(userName, None)
      shouldCreateUser(expectedUser)

      val result = userCreator.create(userId, userName)

      result.futureValue.value shouldBe expectedUser
    }

    "not register an user if already exists with his name" in {
      val userId = UserIdStub.random
      val userName = UserNameStub.random

      shouldFindUserByName(userName, Some(UserStub.create(name = userName)))
      shouldNotCreateUser()

      val result = userCreator.create(userId, userName)

      result.futureValue shouldBe None
    }
  }
}
