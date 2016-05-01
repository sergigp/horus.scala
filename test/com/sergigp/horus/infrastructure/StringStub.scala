package com.sergigp.horus.infrastructure

import scala.util.Random

object StringStub {
  def random(numChars: Int): String = {
    Random.alphanumeric take numChars mkString ""
  }
}
