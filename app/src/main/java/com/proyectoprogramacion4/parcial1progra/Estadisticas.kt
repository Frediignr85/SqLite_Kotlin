package com.proyectoprogramacion4.parcial1progra

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class Estadisticas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estadisticas)



        val context = this
        var db = DatabaseHandlerCalles(this)
        var data = db.readDataAccidents()
        var data1 = db.readDataCarros()
        var data2 = db.readDataMotos()
        var data3 = db.readDataPeatones()


        var ListaDeAccidentes: ArrayList<String> = ArrayList()
        for (i in 0..(data.size - 1)) {
            ListaDeAccidentes.add("Nombre: " + data.get(i).NombreCalle + ", Accidentes: " + data.get(i).NumeroDeAccidentes)
        }
        val listaAccidentes: ListView = findViewById(R.id.listChoques)
        val adapterUserAccidentes = ArrayAdapter(this, android.R.layout.simple_list_item_1, ListaDeAccidentes)
        listaAccidentes.setAdapter(adapterUserAccidentes)


        var ListaCarros: ArrayList<String> = ArrayList()
        for (i in 0..(data1.size - 1)) {
            ListaCarros.add("Nombre: " + data1.get(i).NombreCalle + ", Carros: " + data1.get(i).CantidadCarros)
        }
        val listaCarros: ListView = findViewById(R.id.listCarros)
        val adapterUserCarros = ArrayAdapter(this, android.R.layout.simple_list_item_1, ListaCarros)
        listaCarros.setAdapter(adapterUserCarros)


        var ListaMotos: ArrayList<String> = ArrayList()
        for (i in 0..(data2.size - 1)) {
            ListaMotos.add("Nombre: " + data2.get(i).NombreCalle + ", Motos: " + data2.get(i).CantidadMotos)
        }
        val listaMotos: ListView = findViewById(R.id.listMotos)
        val adapterUserMotos = ArrayAdapter(this, android.R.layout.simple_list_item_1, ListaMotos)
        listaMotos.setAdapter(adapterUserMotos)


        var ListaPeatones: ArrayList<String> = ArrayList()
        for (i in 0..(data3.size - 1)) {
            ListaPeatones.add("Nombre: " + data3.get(i).NombreCalle + ", Peatones: " + data3.get(i).NumeroPeatones)
        }
        val listaPeatones: ListView = findViewById(R.id.listMayoresPeatones)
        val adapterUserPeatones = ArrayAdapter(this, android.R.layout.simple_list_item_1, ListaPeatones)
        listaPeatones.setAdapter(adapterUserPeatones)









    }
}
