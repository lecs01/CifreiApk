package com.example.cifreiapk

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CreateTwo : AppCompatActivity() {

    var nMusica: TextView? = null
    var nArtista: TextView? = null
    var lMusica: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_two)

        nMusica = findViewById(R.id.nMusica)
        nArtista = findViewById(R.id.nArtista)
        lMusica = findViewById(R.id.lMusica)

        val bundle = intent.extras

        nMusica?.setText(bundle!!.getString("nomeMusica","Default"))
        nArtista?.setText(bundle!!.getString("nomeArtista","Default"))
        lMusica?.setText(bundle!!.getString("letraMusica", "Default"))

    }


    fun voltarEdicao(view: View) {
        val intent = Intent(this, CreateOne::class.java)
        startActivity(intent)

    }
}
