package kr.co.bullets.tmdbclientreview.data


import com.google.gson.annotations.SerializedName

data class ArtistList(
    @SerializedName("results")
    val artists: List<Artist>,
)