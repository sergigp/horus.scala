package com.letgo.pusher.infrastructure.json

import scala.util.Try

import play.api.libs.json.{Json, JsValue, Reads, Writes}

object JsonUtils {
  def safeParse(toParse: String): Option[JsValue] = Try(Json.parse(toParse)).toOption

  def safeCast[T: Reads](toCast: JsValue): Option[T] = Try(toCast.as[T]).toOption

  def safeCast[T: Reads](toParse: String): Option[T] = safeParse(toParse).flatMap(_.asOpt[T])

  def safeToJsonString[T: Writes](toSerialize: T): Try[String] = Try(Json.toJson(toSerialize).toString())

  def safeToJson[T: Writes](toSerialize: T): Try[JsValue] = Try(Json.toJson(toSerialize))
}
