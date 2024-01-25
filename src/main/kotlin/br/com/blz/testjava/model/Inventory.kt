package br.com.blz.testjava.model

data class Inventory(
  val id: Long? = null,
  val quantity: Int,
  val warehouses: List<Warehouse>
)
