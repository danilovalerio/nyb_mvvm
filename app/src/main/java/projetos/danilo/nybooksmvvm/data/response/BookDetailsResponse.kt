package projetos.danilo.nybooksmvvm.data.response

import com.google.gson.annotations.SerializedName


//@JsonClass(generateAdapter = true) //importante para fazer o parse
data class BookDetailsResponse (
    @SerializedName("title") //como o nome é o mesmo não precisa do mapeamento
    val title: String,
    @SerializedName("author") //como o nome é o mesmo não precisa do mapeamento
    val author: String,
    @SerializedName("description") //como o nome é o mesmo não precisa do mapeamento
    val description: String

)