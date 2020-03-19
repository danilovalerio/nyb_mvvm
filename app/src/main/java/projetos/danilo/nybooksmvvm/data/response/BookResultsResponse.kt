package projetos.danilo.nybooksmvvm.data.response

import com.google.gson.annotations.SerializedName

//@JsonClass(generateAdapter = true) //importante para fazer o parse
data class BookResultsResponse (
    @SerializedName("book_details") //está na api para mapear
    val bookDetails: List<BookDetailsResponse>
)