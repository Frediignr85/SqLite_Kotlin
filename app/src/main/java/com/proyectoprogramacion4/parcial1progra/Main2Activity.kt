package com.proyectoprogramacion4.parcial1progra

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.content_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setSupportActionBar(toolbar)

        val context = this
        var db = DatabaseHandler(context)
        var db1 = DatabaseHandlerCalles(context)

        var NombrePersona: String? = ""

        val objetoIntent: Intent = intent
        var Nombre = objetoIntent.getStringExtra("Nombre")
        NombrePersona = Nombre.toString()

        btnListaOficiales.setOnClickListener(View.OnClickListener {
            var intent: Intent = Intent(this, ListadoDeOficiales:: class.java)
            startActivity(intent)
        })


        btnAgregarCalles.setOnClickListener(View.OnClickListener {
            var intent: Intent = Intent(this, Main3Activity:: class.java)
            startActivity(intent)

        })

        btnEliminarCalles.setOnClickListener(View.OnClickListener {
            db.deleteData()
            db1.deleteData()

            Toast.makeText(context,"Lista de oficiales y estadisticas borradas", Toast.LENGTH_SHORT).show()
        })

        btnMostrarEstadisticas.setOnClickListener(View.OnClickListener {
            var intent: Intent = Intent(this, Estadisticas:: class.java)
            startActivity(intent)
        })

        fab.setOnClickListener { view ->

            textNombreOficial.setText("Oficial a cargo: " + NombrePersona)
        }
        btnCerrarSesion.setOnClickListener(View.OnClickListener {
            var intent: Intent = Intent(this, MainActivity:: class.java)
            startActivity(intent)
            Toast.makeText(context,"Vuelva pronto oficial " + NombrePersona, Toast.LENGTH_SHORT).show()


        })

    }

}
