package com.mehmetdulger.travelguideapp.ui.search


import com.google.gson.annotations.SerializedName

data class TravelGuideModel(
        @SerializedName("category")
        val category: String,
        @SerializedName("city")
        val city: String,
        @SerializedName("country")
        val country: String,
        @SerializedName("description")
        val description: String,
        @SerializedName("id")
        val id: String,
        @SerializedName("images")
        val images: List<Image>,
        @SerializedName("isBookmark")
        val isBookmark: Boolean,
        @SerializedName("title")
        val title: String
    )
data class Image(
    @SerializedName("altText")
    val altText: Any,
    @SerializedName("height")
    val height: Int,
    @SerializedName("isHeroImage")
    val isHeroImage: Boolean,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)
