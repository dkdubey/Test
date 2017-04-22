package com.galaxyit.checkout

import com.galaxyit.calculator.BillCalculator
import com.galaxyit.cart.{Cart, ShoppingCart}
import com.galaxyit.product.Product

/**
  * Created by dayadubey
  */
class CheckoutSystem(val cart: ShoppingCart) extends Checkout {


  override def addProducts(products: Product*) = {
    cart.addProducts(products: _*)
  }

  override def calculateBill(): BigDecimal = {
    BillCalculator.calculateFinalBill(cart)
  }
}
