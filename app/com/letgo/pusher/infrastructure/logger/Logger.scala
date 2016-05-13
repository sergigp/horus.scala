package com.letgo.pusher.infrastructure.logger

import org.slf4j.LoggerFactory

trait Logger {
  val logger = LoggerFactory.getLogger(this.getClass)
}
