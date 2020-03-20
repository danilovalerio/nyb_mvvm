package projetos.danilo.nybooksmvvm.presentation.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import projetos.danilo.nybooksmvvm.data.ApiService
import projetos.danilo.nybooksmvvm.data.model.Book
import projetos.danilo.nybooksmvvm.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel: ViewModel() {
    //não receber nenhuma referência da activity ou fragment aqui

    //LiveData é componente sugerido para fazer a comunicação com a View
    val livrosLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks(){
//        livrosLiveData.value = createFakeBooks()

        /*val retrofitClient = NetworkUtils.getRetrofitInstance("https://api.nytimes.com/svc/books/v3/")

        val endpoint = retrofitClient.create(NYTServices::class.java)
        val callback =  endpoint.getBooks()

        callback.enqueue(object : Callback<BookBodyResponse> {
            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {
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

        })*/


//        RETROFIT TESTE 1
        ApiService.service.getBooks().enqueue(object : Callback<BookBodyResponse>{
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
            }

            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {

            }

        })
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