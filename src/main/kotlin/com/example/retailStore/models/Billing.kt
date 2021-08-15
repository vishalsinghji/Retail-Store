package com.example.retailStore.models

import com.sun.istack.NotNull
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table
data class Billing(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id:Long ,
        @get: NotNull
        val userId:Long,
        val cartPrice:Double,
        val totalAmount:Double,
        val createdTime: LocalDateTime = LocalDateTime.now()
)
