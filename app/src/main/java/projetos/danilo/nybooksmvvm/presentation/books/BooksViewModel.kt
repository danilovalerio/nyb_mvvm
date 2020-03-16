package projetos.danilo.nybooksmvvm.presentation.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import projetos.danilo.nybooksmvvm.data.model.Book

class BooksViewModel: ViewModel() {
    //não receber nenhuma referência da activity ou fragment aqui

    //LiveData é componente sugerido para fazer a comunicação com a View
    val livrosLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks(){
        livrosLiveData.value = createFakeBooks()

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

    //lista para teste manual
    fun createFakeBooks(): List<Book> {
        return listOf<Book>(
            Book("Clean Code", "Robert C. Martin", "Descricao do livro clean code"),
            Book("Programando com Kotlin", "Stephen Samuel", "Descricao do livro prog com Kotlin"),
            Book("Scrum e Agile em Projetos", "Fábio Cruz", "Descricao do livro scrum agile")
        )
    }
}