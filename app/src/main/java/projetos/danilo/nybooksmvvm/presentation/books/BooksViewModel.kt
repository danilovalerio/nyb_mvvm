package projetos.danilo.nybooksmvvm.presentation.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import projetos.danilo.nybooksmvvm.R
import projetos.danilo.nybooksmvvm.data.ApiService
import projetos.danilo.nybooksmvvm.data.model.Book
import projetos.danilo.nybooksmvvm.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {
    /**Importante: não receber nenhuma referência da activity ou fragment aqui*/

    /**
     * LiveData é componente sugerido para fazer a comunicação com a View*/
    val livrosLiveData: MutableLiveData<List<Book>> = MutableLiveData()
    val viewFlipperLiveData: MutableLiveData<Pair<Int, Int?>> = MutableLiveData()

    fun getBooks() {
//        livrosLiveData.value = createFakeBooks()

        ApiService.service.getBooks().enqueue(object : Callback<BookBodyResponse> {
            override fun onResponse(
                call: Call<BookBodyResponse>,
                response: Response<BookBodyResponse>
            ) {
                if (response.isSuccessful) {
                    val books: MutableList<Book> = mutableListOf()

                    response.body()?.let { bookBodyResponse ->
                        for (result in bookBodyResponse.bookResults) {
                            val book: Book = Book(
                                titulo = result.bookDetails[0].title,
                                autor = result.bookDetails[0].author,
                                descricao = result.bookDetails[0].description
                            )

                            books.add(book)
                        }

                        livrosLiveData.value = books
                        viewFlipperLiveData.value = Pair(VIEW_FLIPPER_BOOKS, null)
                    }
                } else if (response.code() == 401) {
                    viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.books_error_401)
                } else {
                    viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.books_error_400)
                }
            }

            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {
                viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.books_error_500)
            }

        })
    }

    /**Mapemento das posições do ViewFlipper*/
    companion object {
//        private const val VIEW_FLIPPER_LOADER = 0 //já carregada por padrão
        private const val VIEW_FLIPPER_BOOKS = 1
        private const val VIEW_FLIPPER_ERROR = 2
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