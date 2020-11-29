package com.example.cifreiapk

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException
import android.widget.TextView
import android.widget.Toast

class CreateTwo : AppCompatActivity() {

    var nMusica: TextView? = null
    var nArtista: TextView? = null
    var lMusica: TextView? = null
    var nTom: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_two)

        nTom = findViewById(R.id.textViewMostrarTom)

        nMusica = findViewById(R.id.textViewMostrarTitulo)
        nArtista = findViewById(R.id.textViewMostrarArtista)
        lMusica = findViewById(R.id.texViewMostrarLetra)

        val bundle = intent.extras

        val mapNotes = mapOf<String, List<String>>(
            "A" to listOf<String>("A", "Bm", "C#m", "D", "E", "F#m", "G#7ø"),
            "Bb" to listOf<String>("Bb", "Cm", "Dm", "Eb", "F", "Gm", "Aø"),
            "B" to listOf<String>("B", "C#m", "D#m", "E", "F#", "G#m", "A#ø"),
            "C" to listOf<String>("C", "Dm", "Em", "F", "G", "Am", "Bø"),
            "C#" to listOf<String>("C#", "D#m", "E#m", "F#", "G#", "A#m", "Bø"),
            "D" to listOf<String>("D", "Em", "F#m", "G", "A", "Bm", "C#ø"),
            "Eb" to listOf<String>("Eb", "Fm", "Gm", "Ab", "Bb", "Cm", "Dø"),
            "E" to listOf<String>("E", "F#m", "G#m", "A", "B", "C#m", "D#ø"),
            "F" to listOf<String>("F", "Gm", "Am", "Bb", "C", "Dm", "Eø"),
            "F#" to listOf<String>("F#", "G#m", "A#m", "B", "C#", "D#m", "E#ø"),
            "G" to listOf<String>("G", "Am", "Bm", "C", "D", "Em", "F#ø"),
            "Ab" to listOf<String>("Ab", "Bbm", "Cm", "Db", "Eb", "Fm", "Gø"),
            "A" to listOf<String>("A", "Bm", "C#m", "D", "E", "F#m", "G#ø"),
            "Bb" to listOf<String>("Bb", "Cm", "Dm", "Eb", "F", "Gm", "Aø"),
        )

        nMusica?.text = bundle!!.getString("nomeMusica", "Default")
        nArtista?.text = bundle!!.getString("nomeArtista", "Default")
        lMusica?.text = bundle!!.getString("letraMusica", "Default")

        val indiceTomSelecionado = bundle!!.getString("tomSelecionado")
        nTom?.text = bundle!!.getString("tomSelecionado")

        val listaDeAcordes = mapNotes[indiceTomSelecionado]

        val acordeI = findViewById<TextView>(R.id.textViewAcordeI)
        val acordeII = findViewById<TextView>(R.id.textViewAcordeII)
        val acordeIII = findViewById<TextView>(R.id.textViewAcordeIII)
        val acordeIV = findViewById<TextView>(R.id.textViewAcordeIV)
        val acordeV = findViewById<TextView>(R.id.textViewAcordeV)
        val acordeVI = findViewById<TextView>(R.id.textViewAcordeVI)
        val acordeVII = findViewById<TextView>(R.id.textViewAcordeVII)

        acordeI.text = listaDeAcordes?.get(0)
        acordeII.text = listaDeAcordes?.get(1)
        acordeIII.text = listaDeAcordes?.get(2)
        acordeIV.text = listaDeAcordes?.get(3)
        acordeV.text = listaDeAcordes?.get(4)
        acordeVI.text = listaDeAcordes?.get(5)
        acordeVII.text = listaDeAcordes?.get(6)

        fun clickNote(view: View) {
            Toast.makeText(this, ((view) as TextView).text, Toast.LENGTH_SHORT).show()
        }

        /*val btnSalvarArquivo = findViewById<Button>(R.id.btnSalvarArquivo)
        btnSalvarArquivo.setOnClickListener {
            try {
                val fileOutputStream = openFileOutput(nMusica?.text.toString(),
                    MODE_PRIVATE)
                fileOutputStream.write(lMusica?.text.toString().toByteArray())
                fileOutputStream.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }*/
    }

    fun voltarEdicao(view: View) {
        val intent = Intent(this, CreateOne::class.java)
        startActivity(intent)

    }

}