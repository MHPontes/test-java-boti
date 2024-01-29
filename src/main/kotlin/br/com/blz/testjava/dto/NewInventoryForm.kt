package br.com.blz.testjava.dto

import jakarta.validation.Valid
import jakarta.validation.constraints.NotEmpty

data class NewInventoryForm(
  @field:NotEmpty(message = "Warehouses cannot be empty")
  @field:Valid
  val warehouses: MutableList<NewWarehouseForm> = mutableListOf(),
)
