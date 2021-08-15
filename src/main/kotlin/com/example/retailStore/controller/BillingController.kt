package com.example.retailStore.controller

import com.example.retailStore.dtos.BillCreate
import com.example.retailStore.models.Billing
import com.example.retailStore.service.BillingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/billing")
class BillingController {
    @Autowired
    private  lateinit var billingService: BillingService

    @GetMapping("")
    fun getBilling() : List<Billing>{
        return billingService.getAllBills()
    }

    @GetMapping("/{id}")
    fun getBillsById(@PathVariable id: Long) : Billing {
        return  billingService.getBillsById(id)
    }

    @PostMapping("/add")
    fun billGenerate(@RequestBody billgenerate : BillCreate) :Billing{
        return  billingService.create(billgenerate)
    }


    @DeleteMapping("/delete/{id}")
    fun deleteBill(@PathVariable id: Long) : String{
        return billingService.delete(id)
    }
}