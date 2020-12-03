package com.example.cifreiapk

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class VisualizarCifraActivity : AppCompatActivity(){

    var tituloMusica: TextView? = null
    var nomeArtista: TextView? = null
    var letraMusica: TextView? = null
    var tom: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.visualizar_cifra)

        tom = findViewById(R.id.textViewTom)

        tituloMusica = findViewById(R.id.textViewTitulo)
        nomeArtista = findViewById(R.id.textViewArtista)
        letraMusica = findViewById(R.id.textViewLetra)

        val bundle2 = intent.extras

        tituloMusica?.text = bundle2!!.getString("tituloMusica", "Default")
        nomeArtista?.text = bundle2!!.getString("nomeArtista", "Default")
        letraMusica?.text = bundle2!!.getString("letraMusica", "Default")

        val indiceTomSelecionado = bundle2!!.getString("tom")
        tom?.text = bundle2!!.getString("tom")
    }
}