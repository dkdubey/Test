package com.galaxyit.product

trait Product {
  def price: BigDecimal

  def name: String
}

case object Apple extends Product {
  override def price = BigDecimal(0.60)

  override def name = "Apple"
}

case object Orange extends Product {
  override def price = BigDecimal(0.25);

  override def name = "Orange"
}