package br.com.blz.testjava.model

data class Product(
  val sku: Int,
  val name: String,
  val inventory: Inventory,
  val isMarketable: Boolean = true,
)
