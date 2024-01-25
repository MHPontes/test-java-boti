package br.com.blz.testjava.service

import br.com.blz.testjava.dto.ProductView
import br.com.blz.testjava.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
  private val repository: ProductRepository,
  private val productViewMapper: ProductViewMapper
) {

  fun getProductBySku(sku: Int): ProductView {
    val product = repository.getProductBySku(sku)
    return productViewMapper.map(product)
  }
}
