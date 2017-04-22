package com.galaxyit.calculator

import com.galaxyit.cart.Cart
import com.galaxyit.product.Product


object BillCalculator {

  def calculateFinalBill(cart: Cart): BigDecimal = {
    val products = cart.getAllProducts
    var sum = BigDecimal(0);
    for (p <- products) {
      val noOfProducts = cart.getCountFor(p)
      sum += noOfProducts * p.price
    }
    sum
  }
}