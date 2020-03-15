package projetos.danilo.nybooksmvvm.data.response


//@JsonClass(generateAdapter = true) //importante para fazer o parse
data class BookDetailsResponse (
    //@Json(name = "title") //como o nome é o mesmo não precisa do mapeamento
    val title: String,
    //@Json(name = "author") //como o nome é o mesmo não precisa do mapeamento
    val author: String,
    //@Json(name = "description") //como o nome é o mesmo não precisa do mapeamento
    val description: String

)