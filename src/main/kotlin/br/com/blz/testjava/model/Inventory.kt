package br.com.blz.testjava.model

import javax.persistence.*

@Entity
data class Inventory(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long? = null,
  val quantity: Int,
  @OneToMany
  val warehouses: List<Warehouse>
)
