package projetos.danilo.nybooksmvvm.data

import okhttp3.*


//Como vamos instanciar uma única vez o Retrofit nossa ApiService será
// singletone por isso "Objetc ApiService"
object ApiService {



//    private fun initRetroFit(): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl("https://api.nytimes.com/svc/books/v3/")
//            .addConverterFactory(MoshiConverterFactory.create())//esse cara é responsável pela conversão
//            .build()
//    }

    private fun initOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

//    val service:NYTServices = initRetroFit().create(NYTServices::class.java)

}