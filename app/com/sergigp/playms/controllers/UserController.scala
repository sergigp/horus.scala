package com.sergigp.playms.controllers

import java.util.UUID
import javax.inject.Inject

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

import play.api.mvc.Results._
import play.api.mvc._

import com.sergigp.playms.domain.model.{UserId, UserName}
import com.sergigp.playms.domain.service.UserCreator

class UserController @Inject()(userCreator: UserCreator) {

  def post(userId: String) = Action.async { request =>
    request.body.asJson.map { json =>
      (json \ "user_name").asOpt[String].map { userName =>
        userCreator.create(
          UserId(UUID.fromString(userId)), UserName(userName)
        ).map{
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
}
