package com.example.myapplication.response


import com.google.gson.annotations.SerializedName

data class SearchDogResponse(

    @SerializedName("message")
    val message: String?,

    @SerializedName("status")
    val status: String?
)
