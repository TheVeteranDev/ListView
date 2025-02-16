package com.example.listview.dataclasses

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
