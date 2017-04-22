package com.galaxyit.cart

import com.galaxyit.product.Product

/**
  * Created by dayadubey
  */
trait Cart {

  def addProducts(products : Product*)

  def getAllProductsCount: Int

  def getCountFor(product: Product): Int

  def getAllProducts : List[Product]
}
