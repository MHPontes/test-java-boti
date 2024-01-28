package br.com.blz.testjava.service

import br.com.blz.testjava.exception.NotFoundException
import br.com.blz.testjava.mapper.ProductFormMapper
import br.com.blz.testjava.mapper.ProductViewMapper
import br.com.blz.testjava.model.Product
import br.com.blz.testjava.templates.NewProductFormTemplate
import br.com.blz.testjava.templates.ProductTemplate
import br.com.blz.testjava.templates.ProductViewTemplate
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import kotlin.test.assertFailsWith

@ExtendWith(MockKExtension::class)
class ProductServiceTest {

  @MockK
  private lateinit var products: MutableList<Product>

  @MockK
  private lateinit var productViewMapper: ProductViewMapper

  @MockK
  private lateinit var productFormMapper: ProductFormMapper

  @InjectMockKs
  private lateinit var productService: ProductService

  @BeforeEach
  fun setUp() {
    val product = ProductTemplate.createDefaultProduct()
    productService = ProductService(mutableListOf(product), productViewMapper, productFormMapper)

  }

  @Test
  fun `getProductBySku should return ProductView when SKU is valid`() {
    val sku = 123
    val expectedProductView = ProductViewTemplate.createDefaultProductView()

    every { productViewMapper.map(any()) } returns expectedProductView

    val result = productService.getProductBySku(sku)

    assertEquals(expectedProductView, result)

    verify(exactly = 1) { productViewMapper.map(any()) }
  }

  @Test
  fun `getProductBySku should throw NotFoundException when SKU is not found`() {
    val sku = 456

    assertFailsWith<NotFoundException> {
      productService.getProductBySku(sku)
    }
  }

  @Test
  fun `getProductBySku should throw IllegalArgumentException when SKU is not a positive integer`() {
    val sku = -123

    assertFailsWith<IllegalArgumentException> {
      productService.getProductBySku(sku)
    }
  }

  @Test
  fun `should create product and return ProductView`() {
    val form = NewProductFormTemplate.createValidNewProductForm()
    val product = ProductTemplate.createDefaultProduct()
    val expectedProductView = ProductViewTemplate.createDefaultProductView()

    every { products.firstOrNull { it.sku == form.sku } } returns null
    every { productFormMapper.map(form) } returns product
    every { productViewMapper.map(any()) } returns expectedProductView

    productService = ProductService(mutableListOf(), productViewMapper, productFormMapper)

    val result = productService.createProduct(form)

    assertEquals(form.sku, result.sku)
    assertEquals(form.name, result.name)
  }

  @Test
  fun `should throw IllegalStateException when product with SKU already exists`() {
    val form = NewProductFormTemplate.createValidNewProductForm()
    val existingProduct = ProductTemplate.createDefaultProduct()

    every { products.firstOrNull { it.sku == form.sku } } returns existingProduct

    assertFailsWith<IllegalStateException> {
      productService.createProduct(form)
    }
  }

  @Test
  fun `should update product and return updated ProductView`() {
    val sku = 123
    val form = NewProductFormTemplate.createValidNewProductFormUpdate()
    val existingProduct = ProductTemplate.createDefaultProduct()
    val expectedProductView = ProductViewTemplate.createDefaultProductView()

    every { products.firstOrNull { it.sku == sku } } returns existingProduct
    every { productFormMapper.map(form) } returns existingProduct
    every { productViewMapper.map(any()) } returns expectedProductView

    val result = productService.updateProduct(sku, form)

    assertEquals(result.sku, form.sku)
    assertEquals("Product Name Updated", form.name)
  }

  @Test
  fun `should throw NotFoundException when product with SKU not found`() {
    val sku = 1234
    val form = NewProductFormTemplate.createValidNewProductFormSkuDif()

    every { products.firstOrNull { it.sku == sku } } returns null

    assertFailsWith<NotFoundException> {
      productService.updateProduct(sku, form)
    }
  }

  @Test
  fun `should throw IllegalArgumentException when updating SKU is not allowed`() {
    val sku = 123
    val form = NewProductFormTemplate.createValidNewProductFormSkuDif()

    assertFailsWith<IllegalArgumentException> {
      productService.updateProduct(sku, form)
    }
  }

  @Test
  fun `should delete product when SKU exists`() {
    val existingProduct = ProductTemplate.createDefaultProduct()

    productService.deleteProduct(existingProduct.sku)

    val capturedProducts = mutableListOf<Product>()
    every { products.contains(capture(capturedProducts)) } returns true

    assertFalse(capturedProducts.contains(existingProduct), "Product should be removed from the list")
    assertTrue(capturedProducts.isEmpty(), "List should be empty after deletion")
  }
  @Test
  fun `should not delete product when SKU does not exist`() {
    val nonExistentSku = 999

    assertFailsWith<NotFoundException> {
      productService.deleteProduct(nonExistentSku)
    }
  }
}




