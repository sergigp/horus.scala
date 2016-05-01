package com.sergigp.playms.infrastructure

import scala.util.Random

object StringStub {
  def random(numChars: Int): String = {
    Random.alphanumeric take numChars mkString ""
  }
}
