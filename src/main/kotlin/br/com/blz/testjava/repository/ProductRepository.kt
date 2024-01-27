package br.com.blz.testjava.repository

import br.com.blz.testjava.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Int> {

  fun getProductBySku(sku: Int) : Product

//  @Modifying
//  @Query("DELETE FROM Product p WHERE p.sku = :sku")
//  fun deleteProductBySku(@Param("sku") sku: Int)
}
