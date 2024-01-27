package br.com.blz.testjava.service

import br.com.blz.testjava.dto.NewInventoryForm
import br.com.blz.testjava.dto.NewProductForm
import br.com.blz.testjava.dto.NewWarehouseForm
import br.com.blz.testjava.dto.ProductView
import br.com.blz.testjava.mapper.ProductFormMapper
import br.com.blz.testjava.mapper.ProductViewMapper
import br.com.blz.testjava.model.Inventory
import br.com.blz.testjava.model.Product
import br.com.blz.testjava.model.Warehouse
import br.com.blz.testjava.templates.NewProductFormTemplate
import br.com.blz.testjava.templates.ProductTemplate
import br.com.blz.testjava.templates.ProductViewTemplate
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class ProductServiceTest {

  @RelaxedMockK
  private lateinit var products: MutableList<Product>

  @MockK
  private lateinit var productViewMapper: ProductViewMapper

  @MockK
  private lateinit var productFormMapper: ProductFormMapper

  @InjectMockKs
  private lateinit var productService: ProductService

  @BeforeEach
  fun setUp() {
    // Nenhuma inicialização específica necessária ao usar MockK
  }

//  @Test
//  fun `deve buscar product por sku`() {
//
//    val expectedProductView = ProductViewTemplate.createDefaultProductView()
//    val product = ProductTemplate.createDefaultProduct()
//
//    every { products.firstOrNull{ it.sku == expectedProductView.sku } } returns product
//    every { productViewMapper.map(any()) } returns expectedProductView
//
//    val result = productService.getProductBySku(product.sku)
//
//    assertEquals(expectedProductView, result)
//
//    verify(exactly = 1) { productViewMapper.map(any()) }
//    verify(exactly = 1) { products.firstOrNull(any()) }
//  }


  @Test
  fun `should create product successfully`() {
    val form = NewProductFormTemplate.createValidNewProductForm()
    val product = ProductTemplate.createDefaultProduct()
    val expectedProductView = ProductViewTemplate.createDefaultProductView()

    //every { products.firstOrNull { it.sku == form.sku } } returns product
    every { productFormMapper.map(form) } returns product
    every { productViewMapper.map(any()) } returns expectedProductView

    // Act
    val result = productService.createProduct(form)

    // Assert
    assertEquals(expectedProductView, result)
    assertEquals(123, result.sku)
    assertEquals("Product Name", result.name)


    // Verificando as chamadas
    verify(exactly = 1) { products.firstOrNull { it.sku == form.sku } }
    verify(exactly = 1) { productFormMapper.map(form) }
    verify(exactly = 1) { productViewMapper.map(any()) }
    verify(exactly = 1) { products.add(any()) }
  }

  @Test
  fun `should throw exception when creating product with existing SKU`() {
    // Arrange
    val existingProduct = ProductTemplate.createDefaultProduct()
    val expectedProductView = ProductViewTemplate.createDefaultProductView()
    val form = NewProductFormTemplate.createInvalidNewProductForm()


   // every { productFormMapper.map(form) } returns existingProduct // Simula que o mapeamento do formulário não retorna o mesmo produto existente

    every { productFormMapper.map(form) } answers {
      if (it.invocation.args[0] == form) existingProduct
      else mockk() // Retorna um objeto diferente
    }
    every { productViewMapper.map(any()) } returns expectedProductView

    products.add(existingProduct)

    // Act and Assert
    assertThrows<IllegalStateException> {
      productService.createProduct(form)
    }

    // Verificações
    verify(exactly = 1) { productFormMapper.map(form) }
    verify(exactly = 0) { productViewMapper.map(any()) } // Verifica se a mapeação para ProductView não ocorreu
    verify(exactly = 0) { products.add(any()) } // Verifica se a adição de produto não ocorreu
  }

}
