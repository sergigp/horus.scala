package com.letgo.pusher.infrastructure.stub.shared

import com.letgo.pusher.domain.shared.Product.ProductId
import com.letgo.pusher.infrastructure.stub.StringStub

object ProductIdStub {
  def create(id: String = StringStub.random(6)): ProductId = new ProductId(id)

  def random: ProductId = create()
}
