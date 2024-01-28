package br.com.blz.testjava.dto

import br.com.blz.testjava.model.WarehouseType
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class NewWarehouseForm(
  @field:NotBlank(message = "Locality cannot be blank")
  val locality: String,
  @field:NotNull(message = "Quantity cannot be null")
  val quantity: Int,
  @field:NotNull(message = "Type cannot be null")
  val type: WarehouseType
)
