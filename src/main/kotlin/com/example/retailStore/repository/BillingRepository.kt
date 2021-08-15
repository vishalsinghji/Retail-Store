package com.example.retailStore.repository
import com.example.retailStore.models.Billing
import org.springframework.data.jpa.repository.JpaRepository

interface BillingRepository : JpaRepository<Billing,Long>