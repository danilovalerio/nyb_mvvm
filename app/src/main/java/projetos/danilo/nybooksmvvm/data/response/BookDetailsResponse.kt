package projetos.danilo.nybooksmvvm.data.response

import com.google.gson.annotations.SerializedName
import projetos.danilo.nybooksmvvm.data.model.Book

data class BookDetailsResponse (
    @SerializedName("title") //como o nome é o mesmo não precisaria do mapeamento
    val title: String,
    @SerializedName("author") //como o nome é o mesmo não precisaria do mapeamento
    val author: String,
    @SerializedName("description") //como o nome é o mesmo não precisaria do mapeamento
    val description: String
) {
    /**Faz a conversão dos dados em Book*/
    fun getBookModel() = Book(
        titulo = this.title,
        autor = this.author,
        descricao = this.description
    )
}