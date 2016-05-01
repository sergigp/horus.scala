package com.sergigp.playms.tests.acceptance

import com.sergigp.playms.infrastructure.AcceptanceSpec
import com.sergigp.playms.stub.{UserIdStub, UserNameStub, UserStub}

class UserCreationSpec extends AcceptanceSpec {
  "My Application" should {
    "create users" in {
      val response = httpCreateUserCall(UserIdStub.random, UserNameStub.random)

      response.status shouldBe 201
    }

    "return error if required parameters not specified" in {
      val response = httpCreateUserCallWithoutUserName(UserIdStub.random)

      response.status shouldBe 400
    }

    "not create a user if user name already exists" in {
      val userName = UserNameStub.create("johndoe")

      createUser(UserStub.create(name = userName))

      val response = httpCreateUserCall(UserIdStub.random, userName)

      response.status shouldBe 409
    }
  }
}
