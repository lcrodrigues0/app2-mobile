package com.example.dogcatapp.repository.model

import com.google.gson.annotations.SerializedName

class DogFactEntity {
    @SerializedName("facts")
    var fact: Array<String> = arrayOf();

    @SerializedName("success")
    var success: Boolean = false;
}