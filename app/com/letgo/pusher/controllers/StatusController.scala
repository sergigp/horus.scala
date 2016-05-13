package com.letgo.pusher.controllers

import play.api.mvc.{Action, AnyContent}
import play.api.mvc.Results._

class StatusController {
  def get(): Action[AnyContent] = Action { implicit request =>
    Ok
  }
}
