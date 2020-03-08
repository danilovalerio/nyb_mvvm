package projetos.danilo.nybooksmvvm.data

import android.telecom.Call
import projetos.danilo.nybooksmvvm.data.response.BookBodyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTServices {

    //Mapementos do endpoint
    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey: String = "cMg8StZFgc418Wi1UYqnbFuVvs2gNQNn",
        @Query("list") list: String = "hardcover-fiction"
    ): Call<BookBodyResponse>
}