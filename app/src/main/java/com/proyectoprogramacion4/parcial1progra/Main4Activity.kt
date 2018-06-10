package com.proyectoprogramacion4.parcial1progra

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView

import kotlinx.android.synthetic.main.activity_main4.*

class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)


        val context = this
        var db = DatabaseHandlerCalles(this)Inti
        var data = db.readDataAccidents()


        var lista: ArrayList<String> = ArrayList()
        for (i in 0..(data.size - 1)) {
            lista.add("Nombre: " + data.get(i).NombreCalle)
        }
        val lv: ListView = findViewById(R.id.listAccidentes)
        val adapterUser = ArrayAdapter(this, android.R.layout.simple_list_item_1, lista)
        lv.setAdapter(adapterUser)



    }

}
