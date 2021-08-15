package com.example.retailStore.dtos

class BillCreate (val userId:Long ,val cartList: List<CartItemDto>)
class CartItemDto( var quantity:Int ,val productId:Long )