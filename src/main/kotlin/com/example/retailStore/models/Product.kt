package com.example.retailStore.models
import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
@Table
data class Product(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id:Long = 0,
        @get: NotNull
        val name:String = "",
        val category: Category,
        val price:Double,
        val rating:Int
)

enum class Category {
        RETAIL,GROCERY,ELECTRONICS,MOBILE,FASHION,FLIGHT,INSURANCE,SPORTS,REFUBRISHED
}