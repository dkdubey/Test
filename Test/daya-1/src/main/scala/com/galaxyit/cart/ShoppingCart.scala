package com.galaxyit.cart

import com.galaxyit.product.Product


/**
  * Created by dayadubey
  */
class ShoppingCart extends Cart {

  private var productTracker = collection.mutable.Map[Product, Int]()

  override def addProducts(products: Product*): Unit = {

    for (p <- products) {
      val value = productTracker.getOrElse(p, 0) + 1
      productTracker += (p -> value)
    }
  }

  override def getAllProductsCount = {
    productTracker.size
  }

  override def getCountFor(product: Product) = {
    productTracker(product)
  }

  override def getAllProducts = {
    productTracker.keys.toList
  }
}
