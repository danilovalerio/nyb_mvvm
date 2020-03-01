package projetos.danilo.nybooksmvvm.presentation.books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_booksn.*
import projetos.danilo.nybooksmvvm.R

class BooksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booksn)

        toolbarPrincipal.title = getString(R.string.titulo_livros)
        setSupportActionBar(toolbarPrincipal)
    }
}
