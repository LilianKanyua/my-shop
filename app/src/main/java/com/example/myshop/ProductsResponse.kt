package com.example.myshop

data class ProductsResponse(
    var products :List<Procucts>,
    var total :Int,
    var skip:Int,
    var limit:Int
)
