package br.com.blz.testjava.controller

import br.com.blz.testjava.dto.NewProductForm
import br.com.blz.testjava.dto.ProductView
import br.com.blz.testjava.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/products")
class ProductController(private val service: ProductService) {

  @GetMapping("/{sku}")
  fun getProductBySku(@PathVariable sku: Int) : ProductView {
    return service.getProductBySku(sku)
  }

  @PostMapping
  fun createProduct(
    @RequestBody form: NewProductForm,
    uriBuilder: UriComponentsBuilder
  ): ResponseEntity<ProductView> {
    val productView = service.createProduct(form)
    val uri = uriBuilder.path("/products/${productView.sku}").build().toUri()
    return ResponseEntity.created(uri).body(productView)
  }
}
