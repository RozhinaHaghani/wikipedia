package com.example.wikipedia.data

data class ItemPost(
     val imageUrl: String,
     val txtTitle: String,
     val subTitle: String,
     val txtDetail: String,

     //for Trend fragment =>
     val isTrend: Boolean,
     val insight: String
)