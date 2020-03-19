package projetos.danilo.nybooksmvvm.presentation.base

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar

//open é necessário, pois por padrão toda classe kotlin é private
open class BaseActivity : AppCompatActivity() {

    protected fun configurarToolbar(toolbar: Toolbar, tituloIdResource: Int){
        toolbar.title = getString(tituloIdResource)
        setSupportActionBar(toolbar)
    }
}
