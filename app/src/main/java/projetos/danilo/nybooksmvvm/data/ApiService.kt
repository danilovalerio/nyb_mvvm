package projetos.danilo.nybooksmvvm.data

import projetos.danilo.nybooksmvvm.util.ConstantesUtil


/**Como vamos instanciar uma única vez o Retrofit nossa ApiService será
*singletone por isso "Objetc ApiService"*/

object ApiService {

    val retrofitClient = NetworkUtils.getRetrofitInstance(ConstantesUtil.URL_BASE_LIVROS)

    val service:NYTServices = retrofitClient.create(NYTServices::class.java)

}