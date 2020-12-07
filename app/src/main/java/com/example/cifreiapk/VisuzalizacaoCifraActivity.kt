package com.example.cifreiapk

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.cifreiapk.R
import org.w3c.dom.Text

class VisualizacaoCifraActivity : AppCompatActivity() {

    var tvMostrarTitulo: TextView? = null
    var tvMostrarArtista: TextView? = null
    var tvMostrarTom: TextView? = null
    var tvMostrarLetra: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.visuzalizacao_cifra)

        tvMostrarTitulo = findViewById(R.id.tvMostrarTitulo)
        tvMostrarArtista = findViewById(R.id.tvMostrarArtista)
        tvMostrarTom = findViewById(R.id.tvMostrarTom)
        tvMostrarLetra = findViewById(R.id.tvMostrarLetra)

        val bundle = intent.extras

        tvMostrarTitulo?.text = bundle!!.getString("tituloMusica", "Default")
        tvMostrarArtista?.text = bundle.getString("nomeArtista", "Default")
        tvMostrarTom?.text = bundle.getString("tom", "Default")
        tvMostrarLetra?.text = bundle.getString("letraMusica", "Default")

    }
}