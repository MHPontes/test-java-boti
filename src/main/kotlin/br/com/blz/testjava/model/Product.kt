package br.com.blz.testjava.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Product(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long? = null,
  var sku: Int,
  var name: String,
//  @ManyToOne
//  val inventory: Inventory,
//  val isMarketable: Boolean
)
