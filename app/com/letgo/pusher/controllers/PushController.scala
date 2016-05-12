package com.letgo.pusher.controllers

import javax.inject.Inject

import scala.concurrent.Future

import play.api.mvc._
import play.api.mvc.Results._

class PushController @Inject()() {

  def post(): Action[AnyContent] = Action.async { request =>
    Future.successful(Ok)
  }
}
