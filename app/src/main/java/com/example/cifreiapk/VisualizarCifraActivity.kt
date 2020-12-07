package com.example.cifreiapk

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class VisualizarCifraActivity : AppCompatActivity(){

    var tituloMusica: TextView? = null
    var nomeArtista: TextView? = null
    var letraMusica: EditText? = null
    var tom: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.visualizar_cifra)
        setTitle("Visualizacao Cifras")

        tom = findViewById(R.id.tvMostrarTom)

        tituloMusica = findViewById(R.id.tvMostrarTitulo)
        nomeArtista = findViewById(R.id.tvMostrarArtista)
        letraMusica = findViewById(R.id.tvMostrarLetra)

        val bundle2 = intent.extras

        tituloMusica?.text = bundle2!!.getString("tituloMusica", "Default")
        nomeArtista?.text = bundle2.getString("nomeArtista", "Default")
        letraMusica?.setText(bundle2.getString("letraMusica", "Default"), TextView.BufferType.EDITABLE)
        tom?.text = bundle2.getString("tom")
    }
}