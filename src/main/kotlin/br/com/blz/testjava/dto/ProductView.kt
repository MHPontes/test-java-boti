package br.com.blz.testjava.dto

import br.com.blz.testjava.model.Inventory
import com.fasterxml.jackson.annotation.JsonProperty

data class ProductView (
  val sku: Int,
  val name: String,
  val inventory: Inventory,
  @get:JsonProperty("isMarketable")
  val isMarketable: Boolean
)

