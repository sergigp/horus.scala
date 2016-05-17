package com.letgo.pusher.infrastructure.marshaller

import play.api.libs.json.{JsError, _}

import com.letgo.pusher.domain.shared.Product.ProductId

object ProductMarshaller {

  implicit val productIdReads = new Reads[ProductId] {
    override def reads(json: JsValue): JsResult[ProductId] = json match {
      case JsString(id) => JsSuccess(ProductId(id))
      case _ => JsError("invalid product id")
    }
  }
}
