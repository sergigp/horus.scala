package com.letgo.pusher.infrastructure.stub

import scala.util.Random

object StringStub {
  def random(numChars: Int): String = {
    Random.alphanumeric take numChars mkString ""
  }
}
