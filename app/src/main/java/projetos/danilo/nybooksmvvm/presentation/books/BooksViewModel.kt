package projetos.danilo.nybooksmvvm.presentation.books

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.GsonBuilder
import projetos.danilo.nybooksmvvm.data.NYTServices
import projetos.danilo.nybooksmvvm.data.NetworkUtils
import projetos.danilo.nybooksmvvm.data.model.Book
import projetos.danilo.nybooksmvvm.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.security.AccessController.getContext

class BooksViewModel: ViewModel() {
    //não receber nenhuma referência da activity ou fragment aqui

    //LiveData é componente sugerido para fazer a comunicação com a View
    val livrosLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    //okhttp
//    val url = "https://api.nytimes.com/svc/books/v3/"
//
//    val request = Request.Builder()
//        .url(url)
//        .build()
//
//    val client = OkHttpClient()

    fun getBooks(){
//        livrosLiveData.value = createFakeBooks()

        val retrofitClient = NetworkUtils.getRetrofitInstance("https://api.nytimes.com/svc/books/v3/")

        val endpoint = retrofitClient.create(NYTServices::class.java)
        val callback =  endpoint.getBooks()

        callback.enqueue(object : Callback<BookBodyResponse> {
            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {
//                Toast.makeText(this@BooksActivity, t.message, Toast.LENGTH_SHORT).show()
                Log.i("ERROR", t.toString())
            }

            override fun onResponse(
                call: Call<BookBodyResponse>,
                response: Response<BookBodyResponse>
            ) {
                if(response.isSuccessful){
                    val books: MutableList<Book> = mutableListOf()

                    response.body()?.let {bookBodyResponse ->
                        for(result in bookBodyResponse.bookResults){
                            val book: Book = Book(
                                titulo = result.bookDetails[0].title,
                                autor = result.bookDetails[0].author,
                                descricao = result.bookDetails[0].description
                            )

                            books.add(book)
                        }

                        livrosLiveData.value = books
                    }
                }

                Log.i("BODY_RESPONSE",response.body()?.toString())
            }

        })


        //OK HTTP TESTE 2
//        client.newCall(request).enqueue(object : Callback {
//            override fun onResponse(call: Call, response: Response) {
//                val body = response.body()?.string()
//
//                val gson = GsonBuilder().create()
//                val res = gson.fromJson(body, NYTServices::class.java)
//            }
//
//
//            override fun onFailure(call: Call, e: IOException) {
//                Log.i("ERROR","ERRO DE CONEXÃO")
//
//            }
//
//
//        })

        //RETROFIT TESTE 1
//        ApiService.service.getBooks().enqueue(object : Callback<BookBodyResponse>{
//            override fun onResponse(
//                call: Call<BookBodyResponse>,
//                response: Response<BookBodyResponse>
//            ) {
//                if(response.isSuccessful){
//                    val books: MutableList<Book> = mutableListOf()
//
//                    response.body()?.let {bookBodyResponse ->
//                        for(result in bookBodyResponse.bookResults){
//                            val book: Book = Book(
//                                titulo = result.bookDetails[0].title,
//                                autor = result.bookDetails[0].author
//                            )
//
//                            books.add(book)
//                        }
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {
//
//            }
//
//        })
    }

    /** lista fake para teste manual */
    fun createFakeBooks(): List<Book> {
        return listOf<Book>(
            Book("Clean Code", "Robert C. Martin", "Descricao do livro clean code"),
            Book("Programando com Kotlin", "Stephen Samuel", "Descricao do livro prog com Kotlin"),
            Book("Scrum e Agile em Projetos", "Fábio Cruz", "Descricao do livro scrum agile")
        )
    }
}