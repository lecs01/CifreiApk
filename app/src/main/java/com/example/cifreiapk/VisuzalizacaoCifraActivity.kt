package com.example.cifreiapk

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.Lazy as Lazy

class VisualizacaoCifraActivity : AppCompatActivity() {

    private val rotateOpen: Animation by lazy {
        AnimationUtils.loadAnimation(this,
            R.anim.rotate_open_anim)
    }
    private val rotateClose: Animation by lazy {
        AnimationUtils.loadAnimation(this,
            R.anim.rotate_close_anim)
    }
    private val fromBotton: Animation by lazy {
        AnimationUtils.loadAnimation(this,
            R.anim.from_bottom_anim)
    }
    private val toBottom: Animation by lazy {
        AnimationUtils.loadAnimation(this,
            R.anim.to_bottom_anim)
    }

    lateinit var fab_btn: FloatingActionButton
    lateinit var home_btn: FloatingActionButton
    lateinit var edit_btn: FloatingActionButton
    lateinit var print_btn: FloatingActionButton

    private var clicked = false

    var tvMostrarTitulo: TextView? = null
    var tvMostrarArtista: TextView? = null
    var tvMostrarTom: TextView? = null
    var tvMostrarLetra: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.visuzalizacao_cifra)

        fab_btn = findViewById(R.id.fab)
        home_btn = findViewById(R.id.fabHome)
/*
        edit_btn = findViewById(R.id.fabEdit)
        print_btn = findViewById(R.id.fabPrint)
*/

        fab_btn.setOnClickListener {
            onFabButtonClicked()
        }
        home_btn.setOnClickListener { voltarInicio()
            Toast.makeText(this, "Início", Toast.LENGTH_SHORT).show()
        }
/*
        edit_btn.setOnClickListener { voltarEdicao()
            Toast.makeText(this, "Editar", Toast.LENGTH_SHORT).show()
        }
        print_btn.setOnClickListener {
            Toast.makeText(this, "Imprimir", Toast.LENGTH_SHORT).show()
        }
*/


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

    private fun onFabButtonClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        clicked = !clicked
    }

    private fun setVisibility(clicked: Boolean) {
        if (!clicked) {
            home_btn.visibility = View.VISIBLE
/*
            edit_btn.visibility = View.VISIBLE
            print_btn.visibility = View.VISIBLE
*/
        } else {
            home_btn.visibility = View.INVISIBLE
/*
            edit_btn.visibility = View.INVISIBLE
            print_btn.visibility = View.INVISIBLE
*/
        }
    }

    private fun setAnimation(clicked: Boolean) {
        if (!clicked) {
            home_btn.startAnimation(fromBotton)
/*
            edit_btn.startAnimation(fromBotton)
            print_btn.startAnimation(fromBotton)
*/
            fab_btn.startAnimation(rotateOpen)
        } else {
            home_btn.startAnimation(toBottom)
/*
            edit_btn.startAnimation(toBottom)
            print_btn.startAnimation(toBottom)
*/
            fab_btn.startAnimation(rotateClose)
        }
    }

    private fun voltarInicio() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun voltarEdicao() {
        val intent = Intent(this, CriarCifraActivity::class.java)
        startActivity(intent)
    }

}