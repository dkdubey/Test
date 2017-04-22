package com.galaxyit.checkout

import com.galaxyit.product.Product

/**
  * Created by dayadubey
  */
trait Checkout {

  def addProducts(products: Product*)

  def calculateBill(): BigDecimal

}
