package br.com.blz.testjava.dto

import br.com.blz.testjava.model.WarehouseType
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class NewProductForm(
  @field:NotNull(message = "SKU cannot be null")
  @field:Min(value = 1, message = "SKU must be greater than zero")
  val sku: Int,
  @field:NotEmpty(message = "Name cannot be blank")
  val name: String,
  @field:NotNull(message = "Inventory cannot be null")
  val inventory: NewInventoryForm
)

data class NewInventoryForm(
  @field:NotEmpty(message = "Warehouses cannot be empty")
  val warehouses: MutableList<NewWarehouseForm> = mutableListOf(),
)

data class NewWarehouseForm(
  @field:NotBlank(message = "Locality cannot be blank")
  val locality: String,
  @field:NotNull(message = "Quantity cannot be null")
  val quantity: Int,
  @field:NotNull(message = "Type cannot be null")
  val type: WarehouseType
)

data class UpdateProductForm(
  @field:NotNull(message = "SKU cannot be null")
  @field:Min(value = 1, message = "SKU must be greater than zero")
  val sku: Int,
  @field:NotEmpty(message = "Name cannot be blank")
  val name: String,
  @field:NotNull(message = "Inventory cannot be null")
  val inventory: NewInventoryForm
)
