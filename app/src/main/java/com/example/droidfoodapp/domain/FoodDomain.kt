package com.example.droidfoodapp.domain

import java.io.Serializable

class FoodDomain(var title: String,
                 var pic: String,
                 var description: String,
                 var fee: Double,
                 var star: Int,
                 var time: Int,
                 var calories: Int) : Serializable{
    var numberInCart: Int = 0
}