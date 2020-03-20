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


    val retrofitClient = NetworkUtils.getRetrofitInstance("https://api.nytimes.com/svc/books/v3/")

//    val endpoint = retrofitClient.create(NYTServices::class.java)
//    val callback =  endpoint.getBooks()


    val service:NYTServices = retrofitClient.create(NYTServices::class.java)

}