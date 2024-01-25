package br.com.blz.testjava.controller

import br.com.blz.testjava.dto.ProductView
import br.com.blz.testjava.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController(private val service : ProductService){

  @GetMapping("/{sku}")
  fun getProductBySku(@PathVariable sku: Int): ProductView {
    return service.getProductBySku(sku)
  }
}
