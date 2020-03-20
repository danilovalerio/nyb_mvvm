package projetos.danilo.nybooksmvvm.data.response

import com.google.gson.annotations.SerializedName

data class BookResultsResponse (
    @SerializedName("book_details") /**está na api para mapear*/
    val bookDetails: List<BookDetailsResponse>
)