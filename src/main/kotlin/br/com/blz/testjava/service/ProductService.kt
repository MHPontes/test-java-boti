package br.com.blz.testjava.service

import br.com.blz.testjava.dto.NewProductForm
import br.com.blz.testjava.dto.ProductView
import br.com.blz.testjava.dto.UpdateProductForm
import br.com.blz.testjava.mapper.ProductFormMapper
import br.com.blz.testjava.mapper.ProductViewMapper
import br.com.blz.testjava.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
  private val repository: ProductRepository,
  private val productViewMapper: ProductViewMapper,
  private val productFormMapper: ProductFormMapper
) {

  fun getProductBySku(sku: Int): ProductView {
    val product = repository.getProductBySku(sku)
    return productViewMapper.map(product)
  }

  fun createProduct(form: NewProductForm): ProductView {
    val product = productFormMapper.map(form)
    repository.save(product)
    return productViewMapper.map(product)
  }

  fun updateProduct(form: UpdateProductForm): ProductView {
    val existingProduct = repository.getProductBySku(form.sku)
    existingProduct.sku = form.sku
    existingProduct.name = form.name
    return productViewMapper.map(existingProduct)
  }

//  fun deleteProduct(sku: Int) {
//    repository.deleteProductBySku(sku)
//  }
}
