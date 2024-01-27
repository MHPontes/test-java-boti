package br.com.blz.testjava.model

import javax.persistence.*

@Entity
data class Warehouse(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long? = null,
  val locality: String,
  val quantity: Int,
  @Enumerated(value = EnumType.STRING)
  val type: WarehouseType,
  @ManyToOne
  val inventory: Inventory
)
