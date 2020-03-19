package projetos.danilo.nybooksmvvm.data.response

import com.google.gson.annotations.SerializedName

//
//import com.squareup.moshi.Json
//import com.squareup.moshi.JsonClass

//@JsonClass(generateAdapter = true)
data class BookBodyResponse (
    @SerializedName("results")
    var bookResults: List<BookResultsResponse>
)