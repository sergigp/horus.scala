package com.letgo.pusher.controllers.chat


import javax.inject.Inject

import scala.concurrent.Future

import play.api.mvc._
import play.api.mvc.Results._

import com.letgo.pusher.contract.commands.MessageNotificationByInstallationsCommand
import com.letgo.pusher.infrastructure.contract.marshaller.CommandMarshaller._
import com.letgo.pusher.infrastructure.json.JsonUtils

class MessageInstallationController @Inject()() {

  def post(): Action[AnyContent] = Action.async { request =>
    request.body.asJson match {
      case Some(bodyAsJson) =>
        JsonUtils.safeCast[MessageNotificationByInstallationsCommand](bodyAsJson) match {
          case Some(a) =>
            Future.successful(Created)
          case None =>
            Future.successful(BadRequest)
        }
      case None =>
        Future.successful(BadRequest)
    }
  }
}
