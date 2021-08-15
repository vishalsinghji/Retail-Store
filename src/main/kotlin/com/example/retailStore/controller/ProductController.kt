package com.example.retailStore.controller

import com.example.retailStore.models.Product
import com.example.retailStore.models.Users
import com.example.retailStore.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("api/v1/products")
class ProductController {
    @Autowired
    private lateinit var productService: ProductService

    @GetMapping("")
    fun getProducts():List <Product> {
        return productService.getProducts()
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): Product {
        return productService.getProductById(id)
    }

    @PostMapping("/add")
    fun addProduct(@RequestBody product: Product):Product{
        return productService.addProduct(product)
    }

    @PutMapping("/update/{id}")
    fun updateProduct(@PathVariable id: Long ,@RequestBody product:Product){
        return productService.updateProduct(id,product)
    }


    @DeleteMapping("/delete/{id}")
    fun deleteProduct(@PathVariable id: Long) :String{
        return productService.deleteProduct(id)
    }

}