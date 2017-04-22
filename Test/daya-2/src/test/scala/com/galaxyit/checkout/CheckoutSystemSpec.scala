package com.galaxyit.checkout

import com.galaxyit.cart.ShoppingCart
import com.galaxyit.product.{Apple, Orange}
import org.junit.runner.RunWith
import org.scalatest.FunSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CheckoutSystemSpec extends FunSpec {
  describe("Testing checkout system") {

    it("ensures that apple costs 60p and oranges cost 25p") {
      assert(Apple.price == 0.60 && Apple.name == "Apple")
      assert(Orange.price == 0.25 && Orange.name == "Orange")
    }

    it("ensures that shopping Basket is empty on initialisation") {
      val checkoutSystem = new CheckoutSystem(new ShoppingCart)
      assert(checkoutSystem.cart.getAllProductsCount == 0)
    }

    it("ensures products are added properly") {
      val checkoutSystem = new CheckoutSystem(new ShoppingCart)
      checkoutSystem.addProducts(Apple, Orange, Apple, Orange, Apple)

      assert(checkoutSystem.cart.getAllProductsCount == 2)
      assert(checkoutSystem.cart.getCountFor(Apple) == 3)
      assert(checkoutSystem.cart.getCountFor(Orange) == 2)
    }

    it("calculates the final bill on checkout") {
      val checkoutSystem = new CheckoutSystem(new ShoppingCart)
      checkoutSystem.addProducts(Apple, Apple, Orange, Apple)

      val finalBill = checkoutSystem.calculateBill()
      assert(finalBill == BigDecimal(1.45))
    }

    it("returns Zero as final bill when the cart is empty") {
      val checkoutSystem = new CheckoutSystem(new ShoppingCart)
      val finalBill = checkoutSystem.calculateBill()
      assert(finalBill == BigDecimal(0))
    }


    /////////////////////////////////////////////////////////////////////////////////
    //                S T E P  - - ->  2
    /////////////////////////////////////////////////////////////////////////////////
    it("applies offer (buy 1 get 1 FREE) when buying only apples") {
      val checkoutSystem = new CheckoutSystem(new ShoppingCart)
      checkoutSystem.addProducts(Apple, Apple, Apple)
      val finalBill = checkoutSystem.calculateBill()
      assert(finalBill == BigDecimal(1.20))
    }

    it("does NOT apply offer (buy 1 get 1 FREE) when apples are not present in cart") {
      val checkoutSystem = new CheckoutSystem(new ShoppingCart)
      checkoutSystem.addProducts(Orange, Orange, Orange)
      val finalBill = checkoutSystem.calculateBill()
      assert(finalBill == BigDecimal(0.50))
    }

    it("verifies mix and match offer (buy 1 get 1 FREE) with apples and oranges") {
      val checkoutSystem = new CheckoutSystem(new ShoppingCart)
      checkoutSystem.addProducts(Orange, Orange, Orange, Orange, Apple, Apple, Apple, Apple, Apple)
      val finalBill = checkoutSystem.calculateBill()
      assert(finalBill == BigDecimal(2.55))
    }

    it("applies offer (3 for the price of 2 on Oranges) when buying oranges") {
      val checkoutSystem = new CheckoutSystem(new ShoppingCart)
      checkoutSystem.addProducts(Orange, Orange, Orange, Apple)
      val finalBill = checkoutSystem.calculateBill()
      assert(finalBill == BigDecimal(1.10))
    }
  }
}