package projetos.danilo.nybooksmvvm.presentation.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_books_details.*
import kotlinx.android.synthetic.main.include_toolbar.*
import projetos.danilo.nybooksmvvm.R
import projetos.danilo.nybooksmvvm.presentation.base.BaseActivity

class BooksDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books_details)

        configurarToolbar(toolbarPrincipal, R.string.detalhes_livro, true)

        /**pegamos o que virá da intent*/
        val titulo = intent.getStringExtra(EXTRA_TITULO)
        val descricao = intent.getStringExtra(EXTRA_DESCRICAO)

        booksDetailTitle.text = titulo
        booksDetailDescription.text = descricao
    }

    /**Essa activity precisa de um livro*/
    companion object {
        private const val EXTRA_TITULO = "EXTRA_TITLE"
        private const val EXTRA_DESCRICAO = "EXTRA_DESCRICAO"

        fun getStartIntent(contexto: Context, titulo: String, descricao: String): Intent {
            /**Intent(activity origem, activity destino)*/
            return Intent(contexto, BooksDetailsActivity::class.java).apply {
                putExtra(EXTRA_TITULO, titulo)
                putExtra(EXTRA_DESCRICAO, descricao)
            }
        }
    }
}
