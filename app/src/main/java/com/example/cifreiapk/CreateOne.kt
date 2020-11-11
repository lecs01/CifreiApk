package com.example.cifreiapk

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class CreateOne : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_one)

        val spinner: Spinner = findViewById(R.id.spinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.tom,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        var btnProximo: Button? = null
        btnProximo = findViewById(R.id.btnProximo)
        btnProximo?.setOnClickListener(this)
    }

    override fun onClick(view: View) {

        var nomeMusica: EditText? = findViewById(R.id.nomeMusica)
        var nomeArtista: EditText? = findViewById(R.id.nomeArtista)
        var letraMusica: EditText? = findViewById(R.id.letraMusica)

        if (nomeMusica?.equals("")!! || nomeArtista?.equals("")!! || letraMusica?.equals("")!!) {
            val text = "Por favor, insira os dados da Música!"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text,duration)
            toast.show()
        }else{
            val bundle = Bundle()
            bundle.putString("nomeMusica", nomeMusica.toString())
            bundle.putString("nomeArtista", nomeArtista.toString())
            bundle.putString("letraMusica", letraMusica.toString())
            intent = Intent(this, CreateTwo::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

    fun voltarMain(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}

class SpinnerActivity : Activity(), AdapterView.OnItemSelectedListener {
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}