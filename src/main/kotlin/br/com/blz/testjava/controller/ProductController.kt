package br.com.blz.testjava.controller

import br.com.blz.testjava.dto.NewProductForm
import br.com.blz.testjava.dto.ProductView
import br.com.blz.testjava.service.ProductService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/products")
class ProductController(private val service: ProductService) {

  @GetMapping("/{sku}")
  fun getProductBySku(@PathVariable sku: Int): ProductView {
    return service.getProductBySku(sku)
  }

  @PostMapping
  fun createProduct(
    @RequestBody @Valid form: NewProductForm,
    uriBuilder: UriComponentsBuilder
  ): ResponseEntity<ProductView> {
    val productView = service.createProduct(form)
    val uri = uriBuilder.path("/products/${productView.sku}").build().toUri()
    return ResponseEntity.created(uri).body(productView)
  }

  @PutMapping("/{sku}")
  fun updateProduct(@PathVariable @Valid sku: Int, @RequestBody @Valid form: NewProductForm): ResponseEntity<ProductView> {
    val productView = service.updateProduct(sku, form)
    return ResponseEntity.ok(productView)
  }

  @DeleteMapping("/{sku}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  fun deleteProduct(@PathVariable sku: Int) {
    service.deleteProduct(sku)
  }
}
