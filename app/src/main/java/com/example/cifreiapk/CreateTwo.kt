package com.example.cifreiapk

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import org.w3c.dom.Text

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

        nMusica?.setText(bundle!!.getString("nomeMusica"))

    }


    fun voltarEdicao(view: View) {
        val intent = Intent(this, CreateOne::class.java)
        startActivity(intent)

    }
}
