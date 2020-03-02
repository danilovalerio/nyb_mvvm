package projetos.danilo.nybooksmvvm.presentation.books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_booksn.*
import projetos.danilo.nybooksmvvm.R
import projetos.danilo.nybooksmvvm.data.model.Book

class BooksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booksn)

        toolbarPrincipal.title = getString(R.string.titulo_livros)
        setSupportActionBar(toolbarPrincipal)

        with(recyclerBooks) {
            layoutManager = LinearLayoutManager(this@BooksActivity, //chama o contexto de fora da BooksActivity
                RecyclerView.VERTICAL,
                false)
            setHasFixedSize(true)//para melhor performance
            adapter = BooksAdapter(getBooks())
        }
    }

    //lista para teste manual
    fun getBooks(): List<Book> {
        return listOf<Book>(
            Book("Clean Code", "Robert C. Martin"),
            Book("Programando com Kotlin", "Stephen Samuel"),
            Book("Scrum e Agile em Projetos", "Fábio Cruz")
        )
    }
}
