package projetos.danilo.nybooksmvvm.presentation.books

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders

fun provideBooksViewModel(activity: AppCompatActivity) : BooksViewModel {
    return ViewModelProviders.of(
        activity
    ).get(BooksViewModel::class.java)
}