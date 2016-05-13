package com.letgo.pusher.domain.shared

import scala.util.Try

import com.letgo.pusher.domain.shared.Product.ProductId.isNumeric

object Product {

  object ProductId {
    def isNumeric(id: String): Boolean = {
      Try(id.toLong).isSuccess
    }
  }

  case class ProductId(value: String) {
    require(!isNumeric(value), s"$value is not a valid product id")
  }

}
