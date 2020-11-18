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

        val mapNotes
                = mapOf<String, List<String>>(
            "A" to listOf<String>("A", "Bm", "C#m", "D", "E", "F#m", "G#7ø"),
            "Bb" to listOf<String>("Bb", "Cm", "Dm", "Eb", "F", "Gm", "Aø"),
            "B" to listOf<String>("B", "C#m", "D#m", "E", "F#", "G#m", "A#ø"),
            "C" to listOf<String>("C", "Dm", "Em", "F", "G", "Am", "Bø"),
            "C#" to listOf<String>("C#", "D#m", "E#m", "F#", "G#", "A#m", "Bø"),
            "D" to listOf<String>("D", "Em", "F#m", "G", "A", "Bm", "C#ø"),
            "Eb" to listOf<String>("Eb", "Fm", "Gm", "Ab", "Bb", "Cm", "Dø"),
            "E" to listOf<String>("E", "F#m", "G#m", "A", "B", "C#m", "D#ø"),
            "F" to listOf<String>("F", "Gm", "Am", "Bb", "C", "Dm", "Eø"),
            "G" to listOf<String>("G", "Am", "Bm", "C", "D", "Em", "F#ø"),
            "Ab" to listOf<String>("Ab", "Bbm", "Cm", "Db", "Eb", "Fm", "Gø"),
            "A" to listOf<String>("A", "Bm", "C#m", "D", "E", "F#m", "G#ø"),
            "Bb" to listOf<String>("Bb", "Cm", "Dm", "Eb", "F", "Gm", "Aø"),

        )

        nMusica?.setText(bundle!!.getString("nomeMusica","Default"))
        nArtista?.setText(bundle!!.getString("nomeArtista","Default"))
        lMusica?.setText(bundle!!.getString("letraMusica", "Default"))

        val indiceNotaSelecionada
                = bundle!!.getString("notaSelecionada")

        val listaDeNotas = mapNotes.get(indiceNotaSelecionada)

        val textViewI = findViewById<TextView>(R.id.textViewI)
        val textViewII = findViewById<TextView>(R.id.textViewII)
        val textViewIII = findViewById<TextView>(R.id.textViewIII)
        val textViewIV = findViewById<TextView>(R.id.textViewIV)
        val textViewV = findViewById<TextView>(R.id.textViewV)
        val textViewVI = findViewById<TextView>(R.id.textViewVI)
        val textViewVII = findViewById<TextView>(R.id.textViewVII)

        textViewI.text = listaDeNotas?.get(0)
        textViewII.text = listaDeNotas?.get(1)
        textViewIII.text = listaDeNotas?.get(2)
        textViewIV.text = listaDeNotas?.get(3)
        textViewV.text = listaDeNotas?.get(4)
        textViewVI.text = listaDeNotas?.get(5)
        textViewVII.text = listaDeNotas?.get(6)
    }


    fun voltarEdicao(view: View) {
        val intent = Intent(this, CreateOne::class.java)
        startActivity(intent)

    }
}
