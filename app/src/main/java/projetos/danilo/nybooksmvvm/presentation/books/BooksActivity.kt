package projetos.danilo.nybooksmvvm.presentation.books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_books.*
import projetos.danilo.nybooksmvvm.R
import projetos.danilo.nybooksmvvm.data.model.Book
import projetos.danilo.nybooksmvvm.presentation.details.BooksDetailsActivity

class BooksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        toolbarPrincipal.title = getString(R.string.titulo_livros)
        setSupportActionBar(toolbarPrincipal)

        //configuração do viewmodel
        val viewModel: BooksViewModel = ViewModelProviders.of(this).get(BooksViewModel::class.java)

        viewModel.livrosLiveData.observe(this, Observer {
            //só acessa o it se nâo for nulo
            it?.let { livros ->
                with(recyclerBooks) {
                    layoutManager = LinearLayoutManager(this@BooksActivity, //chama o contexto de fora da BooksActivity
                        RecyclerView.VERTICAL,
                        false)
                    setHasFixedSize(true)//para melhor performance
                    adapter = BooksAdapter(livros) {book ->
                        val intent = BooksDetailsActivity.getStartIntent(this@BooksActivity, book.titulo, book.descricao)
                        this@BooksActivity.startActivity(intent)
                    } // livros que está dentro da view model
                }
            }
        })

        viewModel.getBooks()
    }
}
