package com.galaxyit.calculator

import com.galaxyit.cart.Cart
import com.galaxyit.product.{Apple, Offers, Orange}

/**
  * Created by dayadubey
  */
object BillCalculator extends Offers {

  def calculateFinalBill(cart: Cart): BigDecimal = {
    val apples = noOfApplesToBeChargedAfterApplyingBuy1AppleGet1Free(cart)
    val oranges = noOfOrangesToBeChargedAfterApplyingBuy3ForThePriceOf2(cart)
    val finalPrice = oranges * Orange.price + apples * Apple.price
    finalPrice
  }
}