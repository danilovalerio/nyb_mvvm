package projetos.danilo.nybooksmvvm.presentation.books

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_books.*
import kotlinx.android.synthetic.main.include_toolbar.*
import projetos.danilo.nybooksmvvm.R
import projetos.danilo.nybooksmvvm.R.string.titulo_livros
import projetos.danilo.nybooksmvvm.presentation.base.BaseActivity
import projetos.danilo.nybooksmvvm.presentation.details.BooksDetailsActivity

class BooksActivity : BaseActivity() {
    /**configuração do viewmodel*/
    private val viewModel by lazy { provideBooksViewModel(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        configurarToolbar(toolbarPrincipal, titulo_livros)

        viewModel.livrosLiveData.observe(this, Observer {
            /**Com o uso do let só acessa o it se nâo for nulo*/
            it?.let { livros ->
                with(recyclerBooks) {
                    layoutManager = LinearLayoutManager(this@BooksActivity, //chama o contexto de fora da BooksActivity
                        RecyclerView.VERTICAL,
                        false)
                    setHasFixedSize(true)//para melhor performance
                    adapter = BooksAdapter(livros) {book ->
                        val intent = BooksDetailsActivity.getStartIntent(this@BooksActivity, book.titulo, book.descricao)
                        this@BooksActivity.startActivity(intent)
                    } // livros que estão dentro da viewmodel
                }
            }
        })

        viewModel.viewFlipperLiveData.observe(this, Observer {
            it?.let {
                viewFlipper->
                viewFlipperBooks.displayedChild = viewFlipper.first

                viewFlipper.second?.let {erroMessageRespostaId ->
                    tvError.text = getString(erroMessageRespostaId)

                }
            }

        })

        viewModel.getBooks()
    }
}
