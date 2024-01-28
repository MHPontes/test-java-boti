package br.com.blz.testjava.templates

import br.com.blz.testjava.dto.NewInventoryForm
import br.com.blz.testjava.dto.NewProductForm
import br.com.blz.testjava.dto.NewWarehouseForm
import br.com.blz.testjava.model.WarehouseType

object NewProductFormTemplate {

  fun createValidNewProductForm(): NewProductForm {
    return NewProductForm(
      sku = 123,
      name = "Product Name",
      inventory = createValidNewInventoryForm()
    )
  }
  fun createValidNewProductFormUpdate(): NewProductForm {
    return NewProductForm(
      sku = 123,
      name = "Product Name Updated",
      inventory = createValidNewInventoryForm()
    )
  }
  fun createValidNewProductFormSkuDif(): NewProductForm {
    return NewProductForm(
      sku = 777,
      name = "Product Name Updated",
      inventory = createValidNewInventoryForm()
    )
  }

  fun createInvalidNewProductForm(): NewProductForm {
    return NewProductForm(
      sku = 123, // valor inválido
      name = "",
      inventory = createEmptyNewInventoryForm() // inválido, pois deve ter pelo menos um armazém
    )
  }


  private fun createValidNewInventoryForm(): NewInventoryForm {
    return NewInventoryForm(
      warehouses = mutableListOf(
        createValidNewWarehouseForm()
      )
    )
  }

  private fun createEmptyNewInventoryForm(): NewInventoryForm {
    return NewInventoryForm(warehouses = mutableListOf())
  }

  private fun createValidNewWarehouseForm(): NewWarehouseForm {
    return NewWarehouseForm(
      locality = "Warehouse Locality",
      quantity = 10,
      type = WarehouseType.ECOMMERCE
    )
  }
}
