package br.com.blz.testjava.templates

import br.com.blz.testjava.dto.ProductView

object ProductViewTemplate {

    fun createDefaultProductView(): ProductView {
      return ProductView(
        sku = 123,
        name = "Product Name",
        inventory = InventoryTemplate.createDefaultInventory(),
        isMarketable = true
      )
    }
}
