package com.proyectoprogramacion4.parcial1progra

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)


        val contexto1 = this
        var db = DatabaseHandlerCalles(contexto1)
         btnRegistrarCalle.setOnClickListener(View.OnClickListener {
             if (editNombreCalle.text.toString().length > 0 &&
                     editNumeroCarros.text.toString().length > 0 &&
                     editNumeroDeMotos.text.toString().length >0 &&
                     editNumeroPeatones.text.toString().length >0 &&
                     editNumeroAccidentes.text.toString().length >0) {
                 var registroCalles = RegistroCalles(editNombreCalle.text.toString(),editNumeroCarros.text.toString().toInt(), editNumeroDeMotos.text.toString().toInt(), editNumeroPeatones.text.toString().toInt(), editNumeroAccidentes.text.toString().toInt())
                 db.IngresarDatos(registroCalles)

                 editNombreCalle.setText("")
                 editNumeroAccidentes.setText("")
                 editNumeroCarros.setText("")
                 editNumeroDeMotos.setText("")
                 editNumeroPeatones.setText("")



             } else {
                 Toast.makeText(contexto1,"Hay campos que ocupan llenarse",Toast.LENGTH_SHORT).show()
             }
         })


    }

}
