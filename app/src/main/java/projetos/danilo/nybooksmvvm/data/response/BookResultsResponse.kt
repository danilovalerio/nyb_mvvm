package projetos.danilo.nybooksmvvm.data.response

//@JsonClass(generateAdapter = true) //importante para fazer o parse
data class BookResultsResponse (
//    @Json(name = "book_details") //está na api para mapear
    val bookDetails: List<BookDetailsResponse>
)