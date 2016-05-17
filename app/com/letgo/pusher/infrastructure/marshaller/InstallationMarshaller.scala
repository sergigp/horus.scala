package com.letgo.pusher.infrastructure.marshaller

import java.util.UUID

import play.api.libs.json._

import com.letgo.pusher.domain.shared.Installation.{DeviceToken, Installation, InstallationId}


object InstallationMarshaller {

  implicit val installationIdReads = new Reads[InstallationId] {
    override def reads(json: JsValue): JsResult[InstallationId] = json match {
      case JsString(id) => JsSuccess(InstallationId(UUID.fromString(id)))
      case _ => JsError("invalid installation id")
    }
  }

  implicit val deviceTokenReads = new Reads[DeviceToken] {
    override def reads(json: JsValue): JsResult[DeviceToken] = json match {
      case JsString(token) => JsSuccess(DeviceToken(token))
      case _ => JsError("invalid device token")
    }
  }

  implicit val installationReads = new Reads[Installation] {
    override def reads(json: JsValue): JsResult[Installation] = json match {
      case JsObject(installationData) =>
        val data = installationData.get("data").get
        val id = (data \ "id").as[InstallationId]
        val token = (data \ "attributes" \ "device_token").as[DeviceToken]
        JsSuccess(Installation(id, token))
      case _ => JsError("invalid message text")
    }
  }
}
