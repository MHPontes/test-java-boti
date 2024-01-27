package br.com.blz.testjava.model

data class Inventory(
  val quantity: Int,
  val warehouses: List<Warehouse>
)
