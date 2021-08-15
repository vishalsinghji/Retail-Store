package com.example.retailStore.service

import com.example.retailStore.models.Product
import com.example.retailStore.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class ProductService {
    @Autowired
    private lateinit var productRepository:ProductRepository

    fun getProducts(): List<Product> {
        return  productRepository.findAll()
    }
    fun getProductById(id:Long) :Product {
        return productRepository.getById(id)
    }

    fun addProduct(productDetails: Product) :Product {
      return  productRepository.save(productDetails)
    }

    fun updateProduct(id: Long , newProduct: Product){
        productRepository.findById(id).map { existingProduct ->
            val updatedProduct: Product =existingProduct
                .copy(price = newProduct.price,rating = newProduct.rating)
            ResponseEntity.ok().body(productRepository.save(updatedProduct))
        }.orElse(ResponseEntity.notFound().build())
    }
    
    fun deleteProduct(id: Long):String{
        productRepository.deleteById(id)
        return "product has been deleted with id=$id"
    }
}