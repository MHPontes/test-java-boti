package br.com.blz.testjava.templates

import br.com.blz.testjava.model.Inventory
import br.com.blz.testjava.model.Product
import br.com.blz.testjava.model.Warehouse
import br.com.blz.testjava.model.WarehouseType

object ProductTemplate {
  fun createDefaultProduct(): Product {
    return Product(
      sku = 123,
      name = "Default Product",
      inventory = Inventory(
        quantity = 10,
        warehouses = listOf(Warehouse(locality = "Default Locality", quantity = 10, WarehouseType.ECOMMERCE))
      ),
      isMarketable = true
    )
  }
}
