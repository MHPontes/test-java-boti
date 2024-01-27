package br.com.blz.testjava.service

import br.com.blz.testjava.dto.NewProductForm
import br.com.blz.testjava.dto.ProductView
import br.com.blz.testjava.mapper.ProductFormMapper
import br.com.blz.testjava.mapper.ProductViewMapper
import br.com.blz.testjava.model.Product
import org.springframework.stereotype.Service

@Service
class ProductService(
  private var products: List<Product>,
  private val productViewMapper: ProductViewMapper,
  private val productFormMapper: ProductFormMapper,
) {
  init {
    products = mutableListOf()
  }

//  fun getProducts(): List<ProductView> {
//    return products.stream().map { p ->
//      productViewMapper.map(p)
//    }.collect(Collectors.toList())
//  }
  fun getProductBySku(sku: Int): ProductView {
    val product = products.stream().filter { p ->
      p.sku == sku
    }.findFirst().orElse(null)
    return productViewMapper.map(product)
  }

  fun createProduct(form: NewProductForm): ProductView {
    val product = productFormMapper.map(form)
   // product.id = products.size.toLong() + 1
    products.plus(product)
    return productViewMapper.map(product)
  }

}
