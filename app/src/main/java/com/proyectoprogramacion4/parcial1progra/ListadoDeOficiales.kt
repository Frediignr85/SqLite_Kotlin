package com.proyectoprogramacion4.parcial1progra

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast


class ListadoDeOficiales : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_de_oficiales)

        val context = this
        var db = DatabaseHandler(this)
        var data = db.readData()


        var lista: ArrayList<String> = ArrayList()
        for (i in 0..(data.size - 1)) {
            lista.add("Nombre: " + data.get(i).NombreOficial)
        }
        val lv: ListView = findViewById(R.id.listOficiales)
        val adapterUser = ArrayAdapter(this, android.R.layout.simple_list_item_1, lista)
        lv.setAdapter(adapterUser)





    }
}





