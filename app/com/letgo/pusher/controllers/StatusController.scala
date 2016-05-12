package com.letgo.pusher.controllers

import play.api.mvc.Results._
import play.api.mvc.{Action, AnyContent}

class StatusController {
  def get(): Action[AnyContent] = Action { implicit request =>
    Ok
  }
}
