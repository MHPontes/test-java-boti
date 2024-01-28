package br.com.blz.testjava.templates

import br.com.blz.testjava.model.Inventory

object InventoryTemplate {
  fun createDefaultInventory(): Inventory {
    return Inventory(
      quantity = 10,
      warehouses = listOf(WarehouseTemplate.createDefaultWarehouse())
    )
  }
}

