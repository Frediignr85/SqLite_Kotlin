package com.proyectoprogramacion4.parcial1progra

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

/**
 * Created by Fredy on 02/03/2018.
 */


val NOMBRE_BASE_DE_DATOS ="BaseDeDatosCalles"
val NOMBRE_DE_TABLA="Calles"
val COL_CALLE = "NombreCalle"
val COL_CARROS = "Carros"
val COL_MOTOS = "Motos"
val COL_PEATONES = "Peatones"
val COL_ACCIDENTESS = "Accidentes"
val COL_IDENTIFICADOR = "ID"


class DatabaseHandlerCalles(var context: Context) : SQLiteOpenHelper(context, NOMBRE_BASE_DE_DATOS, null, 1)
{
    override fun onCreate(db: SQLiteDatabase?) {

        val tabla = "CREATE TABLE " + NOMBRE_DE_TABLA +" (" +
                COL_IDENTIFICADOR +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_CALLE + " VARCHAR(256)," +
                COL_CARROS +" INTEGER, " +
                COL_MOTOS + " INTEGER, " +
                COL_PEATONES + " INTEGER, "+
                COL_ACCIDENTESS + " INTEGER)"
        db?.execSQL(tabla)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun IngresarDatos(registrocalles: RegistroCalles) {

        val database = this.writableDatabase
        var contentValues = ContentValues()

        contentValues.put(COL_CALLE, registrocalles.NombreCalle)
        contentValues.put(COL_CARROS, registrocalles.CantidadCarros)
        contentValues.put(COL_MOTOS, registrocalles.CantidadMotos)
        contentValues.put(COL_PEATONES, registrocalles.NumeroPeatones)
        contentValues.put(COL_ACCIDENTESS, registrocalles.NumeroDeAccidentes)

        var resultado = database.insert("Calles", null, contentValues)
        if (resultado == -1.toLong())
            Toast.makeText(context, "Registro Fallido de Calle!!", Toast.LENGTH_LONG).show()
        else
            Toast.makeText(context,"Registro Exitoso de Calle!!",Toast.LENGTH_SHORT).show()



    }

    fun deleteData(){
        val db = this.writableDatabase
        db.delete(NOMBRE_DE_TABLA,null,null)
        db.close()
    }

    fun readDataAccidents() : MutableList<RegistroCalles>{

        var lista : MutableList<RegistroCalles> = ArrayList()

        val dab = this.readableDatabase
        val query = "Select * from "+ NOMBRE_DE_TABLA+ " ORDER BY " + COL_ACCIDENTESS + " DESC;"
        val resultado = dab.rawQuery(query,null)

        if(resultado.moveToFirst()){
            do {
                var user = RegistroCalles()
                user.IdCalles = resultado.getString(resultado.getColumnIndex(COL_IDENTIFICADOR)).toInt()
                user.NombreCalle = resultado.getString(resultado.getColumnIndex(COL_CALLE))
                user.CantidadCarros = resultado.getString(resultado.getColumnIndex(COL_CARROS)).toInt()
                user.CantidadMotos = resultado.getString(resultado.getColumnIndex(COL_MOTOS)).toInt()
                user.NumeroPeatones = resultado.getString(resultado.getColumnIndex(COL_PEATONES)).toInt()
                user.NumeroDeAccidentes = resultado.getString(resultado.getColumnIndex(COL_ACCIDENTESS)).toInt()
                lista.add(user)
            }while (resultado.moveToNext())
        }
        resultado.close()
        dab.close()
        return lista
    }


    fun readDataCarros() : MutableList<RegistroCalles>{

        var lista : MutableList<RegistroCalles> = ArrayList()

        val dab = this.readableDatabase
        val query = "Select * from "+ NOMBRE_DE_TABLA+ " ORDER BY " + COL_CARROS + " DESC;"
        val resultado = dab.rawQuery(query,null)

        if(resultado.moveToFirst()){
            do {
                var user = RegistroCalles()
                user.IdCalles = resultado.getString(resultado.getColumnIndex(COL_IDENTIFICADOR)).toInt()
                user.NombreCalle = resultado.getString(resultado.getColumnIndex(COL_CALLE))
                user.CantidadCarros = resultado.getString(resultado.getColumnIndex(COL_CARROS)).toInt()
                user.CantidadMotos = resultado.getString(resultado.getColumnIndex(COL_MOTOS)).toInt()
                user.NumeroPeatones = resultado.getString(resultado.getColumnIndex(COL_PEATONES)).toInt()
                user.NumeroDeAccidentes = resultado.getString(resultado.getColumnIndex(COL_ACCIDENTESS)).toInt()
                lista.add(user)
            }while (resultado.moveToNext())
        }
        resultado.close()
        dab.close()
        return lista
    }


    fun readDataMotos() : MutableList<RegistroCalles>{

        var lista : MutableList<RegistroCalles> = ArrayList()

        val dab = this.readableDatabase
        val query = "Select * from "+ NOMBRE_DE_TABLA + " ORDER BY " + COL_MOTOS + " DESC;"
        val resultado = dab.rawQuery(query,null)

        if(resultado.moveToFirst()){
            do {
                var user = RegistroCalles()
                user.IdCalles = resultado.getString(resultado.getColumnIndex(COL_IDENTIFICADOR)).toInt()
                user.NombreCalle = resultado.getString(resultado.getColumnIndex(COL_CALLE))
                user.CantidadCarros = resultado.getString(resultado.getColumnIndex(COL_CARROS)).toInt()
                user.CantidadMotos = resultado.getString(resultado.getColumnIndex(COL_MOTOS)).toInt()
                user.NumeroPeatones = resultado.getString(resultado.getColumnIndex(COL_PEATONES)).toInt()
                user.NumeroDeAccidentes = resultado.getString(resultado.getColumnIndex(COL_ACCIDENTESS)).toInt()
                lista.add(user)
            }while (resultado.moveToNext())
        }
        resultado.close()
        dab.close()
        return lista
    }

    fun readDataPeatones() : MutableList<RegistroCalles>{

        var lista : MutableList<RegistroCalles> = ArrayList()

        val dab = this.readableDatabase
        val query = "Select * from "+ NOMBRE_DE_TABLA+ " ORDER BY " + COL_PEATONES + " DESC;"
        val resultado = dab.rawQuery(query,null)

        if(resultado.moveToFirst()){
            do {
                var user = RegistroCalles()
                user.IdCalles = resultado.getString(resultado.getColumnIndex(COL_IDENTIFICADOR)).toInt()
                user.NombreCalle = resultado.getString(resultado.getColumnIndex(COL_CALLE))
                user.CantidadCarros = resultado.getString(resultado.getColumnIndex(COL_CARROS)).toInt()
                user.CantidadMotos = resultado.getString(resultado.getColumnIndex(COL_MOTOS)).toInt()
                user.NumeroPeatones = resultado.getString(resultado.getColumnIndex(COL_PEATONES)).toInt()
                user.NumeroDeAccidentes = resultado.getString(resultado.getColumnIndex(COL_ACCIDENTESS)).toInt()
                lista.add(user)
            }while (resultado.moveToNext())
        }
        resultado.close()
        dab.close()
        return lista
    }



}
