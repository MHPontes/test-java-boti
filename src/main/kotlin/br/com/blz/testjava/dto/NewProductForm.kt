package br.com.blz.testjava.dto

import br.com.blz.testjava.model.WarehouseType
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

data class NewProductForm(
  val sku: Int,
  val name: String,
  val inventory: NewInventoryForm
)
@JsonDeserialize
data class NewInventoryForm(
  val warehouses : MutableList<NewWarehouseForm> = mutableListOf(),
)

data class NewWarehouseForm(
  val locality: String,
  val quantity: Int,
  val type: WarehouseType
)
