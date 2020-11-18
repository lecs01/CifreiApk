package com.example.cifreiapk

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class CreateOne : AppCompatActivity(), View.OnClickListener {

    var notaSelecionada: String = "A"
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
        
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                notaSelecionada = (view as TextView).text.toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                notaSelecionada = "A"
            }
        }

        var btnProximo: Button? = null
        btnProximo = findViewById(R.id.btnProximo)
        btnProximo?.setOnClickListener(this)
    }

    override fun onClick(view: View) {

        var nomeMusica: EditText? = findViewById(R.id.nomeMusica)
        var nomeArtista: EditText? = findViewById(R.id.nomeArtista)
        var letraMusica: EditText? = findViewById(R.id.letraMusica)

        if (nomeMusica?.text.toString().isEmpty() || nomeArtista?.text.toString().isEmpty() || letraMusica?.text.toString().isEmpty()){
            Toast.makeText(this,"Insira os dados para criar a cifra!", Toast.LENGTH_SHORT).show()
        }else{



            val bundle = Bundle()
            bundle.putString("nomeMusica", nomeMusica!!.text.toString())
            bundle.putString("nomeArtista", nomeArtista!!.text.toString())
            bundle.putString("letraMusica", letraMusica!!.text.toString())
            bundle.putString("notaSelecionada", notaSelecionada)
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

private fun Bundle.putInt(s: String, notaSelecionada: String) {

}

class SpinnerActivity : Activity(), AdapterView.OnItemSelectedListener {
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}