package com.galaxyit.product

import com.galaxyit.cart.Cart

/**
  * Created by dayadubey
  */
trait Offers {

  def noOfApplesToBeChargedAfterApplyingBuy1AppleGet1Free(cart: Cart): Int = {
    Math.ceil(cart.getCountFor(Apple) / 2.0).toInt
  }

  def noOfOrangesToBeChargedAfterApplyingBuy3ForThePriceOf2(cart: Cart): Int = {
    val oranges = cart.getCountFor(Orange)
    if (oranges <= 2) {
      oranges
    } else {
      Math.ceil(((oranges / 3.0) * 2).toInt + oranges % 3).toInt
    }
  }
}
