package br.com.blz.testjava.dto

import jakarta.validation.Valid
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class NewProductForm(
  @field:NotNull(message = "SKU cannot be null")
  @field:Min(value = 1, message = "SKU must be greater than zero")
  val sku: Int,
  @field:NotEmpty(message = "Name cannot be blank")
  val name: String,
  @field:NotNull(message = "Inventory cannot be null")
  @field:Valid
  val inventory: NewInventoryForm
)

