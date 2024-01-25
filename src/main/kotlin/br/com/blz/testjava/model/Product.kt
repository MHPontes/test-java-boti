package br.com.blz.testjava.model

data class Product(
  val id: Long? = null,
  val sku: Int,
  val name: String,
  val inventory: Inventory,
  val isMarketable: Boolean
)
