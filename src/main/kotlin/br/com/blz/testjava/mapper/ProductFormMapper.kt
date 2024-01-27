package br.com.blz.testjava.mapper

import br.com.blz.testjava.dto.NewProductForm
import br.com.blz.testjava.dto.UpdateProductForm
import br.com.blz.testjava.model.Inventory
import br.com.blz.testjava.model.Product
import br.com.blz.testjava.model.Warehouse
import org.springframework.stereotype.Component

@Component
class ProductFormMapper {
  fun map(newProductForm: NewProductForm): Product {
    val totalQuantity = newProductForm.inventory.warehouses.sumOf { it.quantity }
    val inventory = Inventory(
      quantity = totalQuantity,
      warehouses = newProductForm.inventory.warehouses.map {
        Warehouse(
          locality = it.locality,
          quantity = it.quantity,
          type = it.type
        )
      }
    )

    val isMarketable = totalQuantity > 0

    return Product(
      sku = newProductForm.sku,
      name = newProductForm.name,
      inventory = inventory,
      isMarketable = isMarketable
    )
  }
}
