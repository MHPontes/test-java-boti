package br.com.blz.testjava.model

data class Warehouse(
  var id: Long? = null,
  val locality: String,
  val quantity: Int,
  val type: WarehouseType
)
