package com.example.fran.actionbarcolorlollipop

import android.app.ListActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast

class MainActivity : ListActivity()  {

    internal var cont = 7

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //array adapter
        listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, seisItems(items, 6))
    }

    //bar menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //Opciones del menú
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.anyadir -> anyadirItems()
            R.id.reset -> restablecer()
            R.id.acercade -> acercaDe()
        }
        return true
    }

    fun seisItems(items: Array<String>, cont: Int): Array<String?> {

        val itemsNuevos = arrayOfNulls<String>(cont)

        for (i in 0 until cont) {
            itemsNuevos[i] = items[i]
        }
        return itemsNuevos
    }

    fun anyadirItems() {
        if(cont <= 33){
            listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, seisItems(items, cont++))
        }
    }

    fun restablecer() {
        listAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, seisItems(items, 6))
        cont = 7
    }

    fun acercaDe() {
        val mensaje = "Práctica 3.18. Revisión: ListViews y ActionBar"
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }

    companion object {
        private val items = arrayOf("En", "un", "lugar", "de", "la", "Mancha", "de", "cuyo", "nombre",
                "no", "quiero", "acordarme", "no", "ha", "mucho", "tiempo", "que", "vivía", "un",
                "hidalgo", "de", "los", "de", "lanza", "en", "astillero", "adarga", "antigua", "rocín",
                "flaco", "y", "galgo", "corredor")
    }
}
