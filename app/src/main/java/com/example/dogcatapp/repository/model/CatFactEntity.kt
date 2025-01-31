package com.example.dogcatapp.repository.model

import com.google.gson.annotations.SerializedName

class CatFactEntity {
    @SerializedName("fact")
    var fact : String = "";

    @SerializedName("length")
    var length: Int = 0;
}