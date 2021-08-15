package com.example.retailStore.models

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table
data class Users(
    @Id
    @GeneratedValue
    var id:Long=-1,
    var name:String="",
    var phone:String="",
    var address: String,
    val userType: UserType,
    var createdTime:LocalDateTime= LocalDateTime.now()
) {
    fun isEligible(): Boolean {
        val currentDateTime = LocalDateTime.now().minusYears(2)
        return createdTime.isBefore(currentDateTime) && (userType == UserType.customer)
    }

    enum class UserType(type: Int, discountPercentage: Int) {
        employee(1, 30),
        affiliate(2, 10),
        customer(3, 5);

        private val userTypeId: Int = type
        private val discountPercentage: Int = discountPercentage

        fun getDiscountPercentage(): Int {
            return this.discountPercentage
        }
    }
}





