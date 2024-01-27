package br.com.blz.testjava.mapper

import br.com.blz.testjava.dto.NewProductForm
import br.com.blz.testjava.model.Inventory
import br.com.blz.testjava.model.Product
import org.springframework.stereotype.Component

@Component
class ProductFormMapper : Mapper<NewProductForm, Product> {
  override fun map(p: NewProductForm) : Product{
    return Product(
      sku = p.sku,
      name = p.name,
//      inventory = Inventory(
//        id = inventory,
//        quantity =
//      )
//      isMarketable = false
     // inventory = p.inventory,
    )
  }

}
