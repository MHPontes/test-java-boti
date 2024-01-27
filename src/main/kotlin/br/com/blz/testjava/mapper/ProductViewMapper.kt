package br.com.blz.testjava.mapper

import br.com.blz.testjava.dto.ProductView
import br.com.blz.testjava.model.Product
import org.springframework.stereotype.Component

@Component
class ProductViewMapper : Mapper<Product, ProductView> {
  override fun map(p: Product): ProductView {
    return ProductView(
      sku = p.sku,
      name = p.name,
      inventory = p.inventory,
      isMarketable = p.isMarketable
    )
  }
}
