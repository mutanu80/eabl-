package com.example.eabl

interface Product {

    interface ItemClickListener {
        fun increaseToCart(item: CartProduct, position: Int)
        fun decreaseFromCart(item : CartProduct, position : Int)
        fun deleteFromCart(item : CartProduct, position : Int)
    }
}