package br.com.blz.testjava.repository

import br.com.blz.testjava.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Int> {

}
