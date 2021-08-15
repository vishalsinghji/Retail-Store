package com.example.retailStore.service

import com.example.retailStore.dtos.BillCreate
import com.example.retailStore.models.Billing
import com.example.retailStore.models.Category
//import com.example.retailStore.models.UserType
import com.example.retailStore.models.Users
import com.example.retailStore.repository.BillingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Math.floor

@Service
class BillingService {

    @Autowired
    private  lateinit var productService: ProductService

    @Autowired
    private lateinit var usersService: UsersService

    @Autowired
    private lateinit var billingRepository: BillingRepository


    fun getAllBills() : List<Billing>{
        return  billingRepository.findAll()
    }
    fun getBillsById(id:Long) : Billing {
        return  billingRepository.getById(id)
    }

    fun create(cartbill: BillCreate): Billing {
        val user = usersService.getUserById(cartbill.userId)
        val (cartAmount, cartGroceryValue) = getCartValue(cartbill)
        val  amountPayable = applyUserDiscount(cartAmount, cartGroceryValue, user)
        val bill = Billing(0,userId = user.id, cartPrice = cartAmount, totalAmount = amountPayable)
        return billingRepository.save(bill)
    }

    fun getCartValue(cartbill: BillCreate) : List<Double>{
        var cartAmount  = 0.0
        var cartGroceryValue  = 0.0
        for (item in cartbill.cartList){
            val product = productService.getProductById(item.productId)
            val productValue = product.price * item.quantity
            cartAmount+=productValue
            if (product.category == Category.GROCERY)
                    cartGroceryValue+=productValue
        }
        return listOf(cartAmount,cartGroceryValue)
    }

    fun applyUserDiscount(cartValue: Double, cartGroceryValue: Double, user: Users): Double {
        var discountPercentage =0
        if (user.userType == Users.UserType.employee || user.userType == Users.UserType.affiliate || user.isEligible()){
            discountPercentage= user.userType.getDiscountPercentage()
        }
        println("The Dicount percentage applied on bill is =$discountPercentage")
        var discountValue = cartValue - cartGroceryValue
        println("The Total Amount of the cart without discount: $cartValue")
        discountValue = discountValue * discountPercentage / 100
        println("Total Discount amount=$discountValue")
        val amountAfterUserDiscount = cartValue - discountValue
        println("Net amount to be paid=$amountAfterUserDiscount")
        return (amountAfterUserDiscount - floor(amountAfterUserDiscount / 100) * 5)

    }

    fun delete(id: Long) : String {
        billingRepository.deleteById(id)
        return "Bill has been deleted for ${id}"
    }
}