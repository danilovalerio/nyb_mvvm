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
    }

    //lista para teste manual
    fun createFakeBooks(): List<Book> {
        return listOf<Book>(
            Book("Clean Code", "Robert C. Martin"),
            Book("Programando com Kotlin", "Stephen Samuel"),
            Book("Scrum e Agile em Projetos", "Fábio Cruz")
        )
    }
}