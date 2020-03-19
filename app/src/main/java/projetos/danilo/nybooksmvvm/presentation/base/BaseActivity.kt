package projetos.danilo.nybooksmvvm.presentation.base

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar

class BaseActivity : AppCompatActivity() {

    protected fun setupToolbar(toolbar: Toolbar, tituloIdRes: Int){
        toolbar.title = getString(tituloIdRes)
        setSupportActionBar(toolbar)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
