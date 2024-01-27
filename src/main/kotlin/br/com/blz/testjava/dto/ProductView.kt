package br.com.blz.testjava.dto

import br.com.blz.testjava.model.Inventory

data class ProductView (
  val sku: Int,
  val name: String,
  val inventory: Inventory,
  val isMarketable: Boolean
)

