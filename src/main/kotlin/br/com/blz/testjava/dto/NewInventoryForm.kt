package br.com.blz.testjava.dto

import jakarta.validation.constraints.NotEmpty

data class NewInventoryForm(
  @field:NotEmpty(message = "Warehouses cannot be empty")
  val warehouses: MutableList<NewWarehouseForm> = mutableListOf(),
)
