package br.com.blz.testjava.dto

import br.com.blz.testjava.model.Inventory

data class NewProductForm(
  val sku: Int,
  val name: String,
  val inventory: Inventory
)
