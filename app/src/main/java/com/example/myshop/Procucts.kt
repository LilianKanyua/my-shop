package com.example.myshop

import android.accessibilityservice.GestureDescription.StrokeDescription

data class Procucts(
    var id :Int,
    var title:String,
    var description: String,
    var price:Double,
    var rating :Double,
    var stock:Int,
    var category:String,
    var thumbnail: String
)
