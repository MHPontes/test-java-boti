package br.com.blz.testjava.dto

import br.com.blz.testjava.model.Inventory

data class NewProductForm (
  val name: String,
  val sku: Int,
  //val inventory: Inventory
)
