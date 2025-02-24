package com.hammer67.sqlitekotlin

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class mySqliteHelper(context: Context):SQLiteOpenHelper(
    context,"amigos.db", null,1) {


    //Creamos la tabla
    override fun onCreate(db: SQLiteDatabase?) {
        val ordenCreacion = "CREATE TABLE amigos" + "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT, email TEXT)"

        db!!.execSQL(ordenCreacion)
    }

    //Control de versiones
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val ordenBorrado = "DROP TABLE IF EXISTS amigos"
        db!!.execSQL(ordenBorrado)
        onCreate(db)
    }

    //Codigo para agregar nuevos campos...
    fun agregarDatos(nombre:String, email: String, password: String){
        val datos = ContentValues()
        datos.put("nombre", nombre)
        datos.put("email", email)
        datos.put("password", password)

        val db = writableDatabase
        db.insert("amigos", null,datos)
        db.close()
    }

}