package projetos.danilo.nybooksmvvm.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

//Como vamos instanciar uma única vez o Retrofit nossa ApiService será
// singletone por isso "Objetc ApiService"
object ApiService {

    private fun initRetroFit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/books/v3/")
            .addConverterFactory(MoshiConverterFactory.create())//esse cara é responsável pela conversão
            .build()
    }

    val service = initRetroFit().create(NYTServices::class.java)
}