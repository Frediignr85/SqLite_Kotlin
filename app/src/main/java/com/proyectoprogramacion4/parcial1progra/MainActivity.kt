package com.proyectoprogramacion4.parcial1progra

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val context = this
        var db = DatabaseHandler(context)




        btnRegistrar.setOnClickListener({
            if (editCodigoOficial.text.toString().length > 0 &&
                    editNombreOficial.text.toString().length > 0) {
                var user = UsuariosOficiales(editNombreOficial.text.toString(),editCodigoOficial.text.toString())
                db.insertarDatos(user)



                var Nombre: String = editNombreOficial.text.toString()
                Toast.makeText(context,"Bienvenid@ " + Nombre ,Toast.LENGTH_SHORT).show()
                var intent: Intent = Intent(this, Main2Activity:: class.java)
                intent.putExtra("Nombre", Nombre)

                editCodigoOficial.setText("")
                editNombreOficial.setText("")

                startActivity(intent)


            } else {
                Toast.makeText(context,"Hay campos que ocupan llenarse",Toast.LENGTH_SHORT).show()
            }



        })


    }
}
