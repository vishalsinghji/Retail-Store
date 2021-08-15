package com.example.retailStore.repository

import com.example.retailStore.models.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product,Long>