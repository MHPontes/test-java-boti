package br.com.blz.testjava.templates

import br.com.blz.testjava.model.Warehouse
import br.com.blz.testjava.model.WarehouseType

object WarehouseTemplate {

  fun createDefaultWarehouse(): Warehouse {
    return Warehouse(
      locality = "Default Locality",
      quantity = 10,
      type = WarehouseType.ECOMMERCE
    )
  }
}
