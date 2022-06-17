package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.myapp.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.delay

/*
class MainActivity : AppCompatActivity() {

    val TAG = "MiActividad"
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView =  findViewById(R.id.tv_m)
        textView.text = "Fernando"

        val button: Button = findViewById(R.id.btn_m)
        val editText: EditText = findViewById(R.id.et_m)
        val image : ImageView = findViewById(R.id.iv_m)

        button.setOnClickListener {
            image.visibility = View.VISIBLE
            if(!editText.text.isEmpty()){
                Toast.makeText(this,editText.text,Toast.LENGTH_SHORT).show()
                textView.text= editText.text
            }else{
                Toast.makeText(this,"No hay texto",Toast.LENGTH_SHORT).show()
            }
        }

    }
}*/

class MainActivity : AppCompatActivity(){
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        inicio(view)

    }
    private fun inicio(view: LinearLayoutCompat) {

        lifecycleScope.launchWhenStarted {
            binding.probM.isVisible = true
            delay(3000)
            binding.probM.isVisible = false

        }

        binding.etM.setOnClickListener {
            binding.ibM.visibility = View.VISIBLE
            if (!binding.etM.text.isEmpty()) {
                Toast.makeText(this, binding.etM.text, Toast.LENGTH_SHORT).show()
                binding.tvM.text = binding.etM.text
            } else {
                Toast.makeText(this, "No hay texto", Toast.LENGTH_SHORT).show()
            }
        }
        MaterialAlertDialogBuilder(view.context)
            .setTitle("MI DIALOGO")
            .setMessage("este es un dialogo con md3")
            .setNeutralButton("Cancelar "){ dialog, wich ->

            }
            .setNegativeButton("Rechazar"){ dialog, wich ->

            }
            .setPositiveButton("Aceptar"){ dialog, wich ->

            }
            .show()

    }

}
