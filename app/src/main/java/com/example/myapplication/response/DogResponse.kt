package com.example.myapplication.response


import com.google.gson.annotations.SerializedName

data class DogResponse(

    @SerializedName("message")
    val message: List<String>?,

    @SerializedName("status")
    val status: String?
)
