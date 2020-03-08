package projetos.danilo.nybooksmvvm.data

import android.telecom.Call
import retrofit2.http.GET

interface NYTServices {

    //configuração do endpoint
    @GET("users/{user}/repos")
    fun listRepos(): Call<List<Repo?>?>?
}