package com.proyectoprogramacion4.parcial1progra

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import android.R.attr.name
import android.database.Cursor


/**
 * Created by Fredy on 02/03/2018.
 */

val DATABASE_NAME ="MiBaseDeDatos"
val TABLE_NAME="Usuarios"
val COL_NAME = "Nombre"
val COL_CODIGO = "Codigo"
val COL_ID = "id"


class DatabaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME +" (" +
                COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NAME + " VARCHAR(256)," +
                COL_CODIGO +" VARCHAR(15))"

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    fun insertarDatos(usuariosOficiales: UsuariosOficiales) {
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAME,usuariosOficiales.NombreOficial)
        cv.put(COL_CODIGO,usuariosOficiales.CodigoOficial)
        var result = db.insert(TABLE_NAME,null,cv)
        if(result == -1.toLong())
            Toast.makeText(context,"Registro Fallido!!",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"Registro Exitoso!!",Toast.LENGTH_SHORT).show()

    }

    fun readData() : MutableList<UsuariosOficiales>{
        var list : MutableList<UsuariosOficiales> = ArrayList()

        val db = this.readableDatabase
        val query = "Select * from " + TABLE_NAME
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                var user = UsuariosOficiales()
                user.Id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                user.NombreOficial = result.getString(result.getColumnIndex(COL_NAME))
                user.CodigoOficial = result.getString(result.getColumnIndex(COL_CODIGO))
                list.add(user)
            }while (result.moveToNext())
        }
        result.close()
        db.close()
        return list
    }




    fun deleteData(){
        val db = this.writableDatabase
        db.delete(TABLE_NAME,null,null)
        db.close()
    }


}
