package hoon.exam.nowinhoonsearch.network

import com.google.gson.annotations.SerializedName

data class NaverSearchResponse(
    @SerializedName("total")
    val total: Int = 0,
    @SerializedName("lastBuildDate")
    val lastBuildDate: String = "",
    @SerializedName("start")
    val start: Int = 0,
    @SerializedName("display")
    val display: Int = 0,
    @SerializedName("items")
    val items: List<NaverSearchResponseItemDetail>
)

data class NaverSearchResponseItemDetail(
    @SerializedName("title")
    val title: String = "",
    @SerializedName("link")
    val link: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("image")
    val image: String = "",
    @SerializedName("pubDate")
    val pubDate: String = "",
    @SerializedName("author")
    val author: String = "",
    @SerializedName("discount")
    val discount: Int = 0,
    @SerializedName("publisher")
    val publisher: String = "",
)