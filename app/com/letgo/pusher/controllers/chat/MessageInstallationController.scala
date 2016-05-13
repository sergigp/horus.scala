package com.letgo.pusher.controllers.chat


import javax.inject.Inject

import scala.concurrent.Future

import play.api.mvc._
import play.api.mvc.Results._

class MessageInstallationController @Inject()() {

  def post(): Action[AnyContent] = Action.async { request =>
    Future.successful(Created)
  }
}
