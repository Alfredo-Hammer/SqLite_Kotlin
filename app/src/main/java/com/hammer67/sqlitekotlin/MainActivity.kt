package com.hammer67.sqlitekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hammer67.sqlitekotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var amigosDBHelper: mySqliteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        amigosDBHelper = mySqliteHelper(this)

        binding.buttonSave.setOnClickListener {
            if (binding.textInputName.text!!.isNotEmpty()
                && binding.textInputEmail.text!!.isNotEmpty()
                && binding.textInputPassword.text!!.isNotEmpty()
            ) {
                amigosDBHelper.agregarDatos(
                    binding.textInputName.text.toString(),
                    binding.textInputEmail.text.toString(),
                    binding.textInputPassword.text.toString()
                )
                binding.textInputName.text!!.clear()
                binding.textInputEmail.text!!.clear()
                binding.textInputPassword.text!!.clear()

                Toast.makeText(this,"Datos guardados satisfactoriamente",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this,"Llenar los campos para continuar...",Toast.LENGTH_LONG).show()

            }
        }
    }
}