package com.sergigp.horus.controllers

import java.util.UUID
import javax.inject.Inject

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

import play.api.libs.json.{JsObject, JsString}
import play.api.mvc.Results._
import play.api.mvc._

import com.sergigp.horus.domain.model.{UserId, UserName}
import com.sergigp.horus.domain.service.{UserCreator, UserSearcher}

class UserController @Inject()(userCreator: UserCreator, userSearcher: UserSearcher) {

  def post(userId: String) = Action.async { request =>
    request.body.asJson.map { json =>
      (json \ "user_name").asOpt[String].map { userName =>
        userCreator.create(
          UserId(UUID.fromString(userId)), UserName(userName)
        ).map {
          case Some(user) => Created
          case None => Conflict
        }
      }.getOrElse {
        Future.successful(BadRequest("Missing parameter [name]"))
      }
    }.getOrElse {
      Future.successful(BadRequest("Expecting Json data"))
    }
  }

  def get(userId: String) = Action.async {
    userSearcher.search(UserId(UUID.fromString(userId))).map {
      case Some(user) =>
        Ok(JsObject(Seq("user_id" -> JsString(user.id.value.toString), "user_name" -> JsString(user.name.value))))
      case None => NotFound
    }
  }
}
