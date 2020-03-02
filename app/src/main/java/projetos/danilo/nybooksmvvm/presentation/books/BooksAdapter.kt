package projetos.danilo.nybooksmvvm.presentation.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_book.view.*
import projetos.danilo.nybooksmvvm.R
import projetos.danilo.nybooksmvvm.data.model.Book

class BooksAdapter(
        val livros: List<Book>
) : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BooksViewHolder(itemView)
    }

    override fun getItemCount() = livros.count()

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bindView(livros[position])
    }

    class BooksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titulo = itemView.textoTitulo
        val autor = itemView.textoAutor

        fun bindView(book: Book){
            titulo.text = book.titulo
            autor.text = book.autor
        }
    }
}