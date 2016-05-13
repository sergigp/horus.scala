package com.letgo.pusher.domain.chat

import scala.util.Try

import com.letgo.pusher.domain.chat.Talker.TalkerId.isNumeric

object Talker {

  object TalkerId {

    def isNumeric(talkerId: String): Boolean = {
      Try(talkerId.toLong).isSuccess
    }
  }

  case class TalkerId(value: String) {
    require(!isNumeric(value), s"$value is not a valid talker id")
  }


  case class TalkerName(value: String)

}
