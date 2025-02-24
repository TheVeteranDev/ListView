package com.example.listview.dataclasses

/**
 * Movie data class with all private values and getters, no need for setters in this project
 */
data class Movie(
    private val title: String,
    private val subTitle: String,
    private val boxArtDrawable: Int
) {
    fun getTitle(): String {
        return title
    }

    fun getSubTitle(): String {
        return subTitle
    }

    fun getBoxArtDrawable(): Int {
        return boxArtDrawable
    }
}
