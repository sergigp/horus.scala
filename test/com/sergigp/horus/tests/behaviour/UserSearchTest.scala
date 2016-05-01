package com.sergigp.horus.tests.behaviour

import com.sergigp.horus.domain.service.UserSearcher
import com.sergigp.horus.infrastructure.BehaviourTest
import com.sergigp.horus.stub.{UserIdStub, UserStub}

class UserSearchTest extends BehaviourTest {

  def userSearcher = new UserSearcher(userRepository)

  "User Searcher" should {
    "return existing users" in {
      val userId = UserIdStub.random
      val expectedUser = UserStub.create(id = userId)

      shouldFindUser(userId, Some(expectedUser))

      val result = userSearcher.search(userId)

      result.futureValue.value shouldBe expectedUser
    }

    "return anything if user does not exists" in {
      val userId = UserIdStub.random

      shouldFindUser(userId, None)

      val result = userSearcher.search(userId)

      result.futureValue shouldBe None
    }
  }
}
