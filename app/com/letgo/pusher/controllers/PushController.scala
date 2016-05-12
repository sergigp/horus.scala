package com.letgo.pusher.controllers

import javax.inject.Inject

import scala.concurrent.Future

import play.api.mvc.Results._
import play.api.mvc._

class PushController @Inject()() {

  def post(userId: String) = Action.async { request =>
    Future.successful(Ok)
  }
}
