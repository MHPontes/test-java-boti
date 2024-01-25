package br.com.blz.testjava.model

data class Warehouse(
  val id: Long? = null,
  val locality: String,
  val quantity: Int,
  val type: WarehouseType
)
