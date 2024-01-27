//package br.com.blz.testjava.mapper
//
//import br.com.blz.testjava.dto.NewProductForm
//import br.com.blz.testjava.model.Inventory
//import br.com.blz.testjava.model.Product
//import br.com.blz.testjava.model.Warehouse
//
//class TestMapper {
//
//}
//
//fun NewProductForm.toProduct(): Product {
//  val totalQuantity = this.inventory.warehouses.sumOf { it.quantity }
//  val inventory = Inventory(
//    quantity = totalQuantity,
////    quantity = this.inventory.warehouses.sumOf { it.quantity },
////    quantity = 1,
//    warehouses = this.inventory.warehouses.map {
//      Warehouse(
//        locality = it.locality,
//        quantity = it.quantity,
//        type = it.type
//      )
//    }
//  )
//
//  val isMarketable = totalQuantity > 0
//
//  return Product(
//    sku = this.sku,
//    name = this.name,
//    inventory = inventory,
//    isMarketable = isMarketable
//  )
//}
