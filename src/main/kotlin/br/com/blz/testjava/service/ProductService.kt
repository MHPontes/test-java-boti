package br.com.blz.testjava.service

import br.com.blz.testjava.dto.NewProductForm
import br.com.blz.testjava.dto.ProductView
import br.com.blz.testjava.exception.NotFoundException
import br.com.blz.testjava.mapper.ProductFormMapper
import br.com.blz.testjava.mapper.ProductViewMapper
import br.com.blz.testjava.model.Product
import org.springframework.stereotype.Service

@Service
class ProductService(
  private var products: MutableList<Product>,
  private val productViewMapper: ProductViewMapper,
  private val productFormMapper: ProductFormMapper,
) {

  fun getProductBySku(sku: Int): ProductView {
    require(sku > 0) { "SKU must be a positive integer" }

    return products.firstOrNull { it.sku == sku }
      ?.let { productViewMapper.map(it) }
      ?: throw NotFoundException("Product with SKU $sku not found")
  }

  fun createProduct(form: NewProductForm): ProductView {
    products.firstOrNull { it.sku == form.sku }
      ?.let { throw IllegalStateException("Product with SKU ${form.sku} already exists") }
    val product = productFormMapper.map(form)
    products.add(product)
    return productViewMapper.map(product)
  }

  fun updateProduct(sku: Int, form: NewProductForm): ProductView {
    val existingProduct = products.firstOrNull { it.sku == sku }
      ?: throw NotFoundException("Product with SKU $sku not found")

    if (form.sku != sku) throw IllegalArgumentException("Updating SKU $sku is not allowed")

    products = products.filterNot { it.sku == existingProduct.sku }
      .plus(productFormMapper.map(form))
      .toMutableList()

    return productViewMapper.map(productFormMapper.map(form))
  }

  fun deleteProduct(sku: Int) {
    val product = products.firstOrNull { it.sku == sku }
      ?: throw NotFoundException("Product with SKU $sku not found")
    products.remove(product)
  }
}
