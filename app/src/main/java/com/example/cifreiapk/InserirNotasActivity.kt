package com.example.cifreiapk

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.example.cifreiapk.model.Cifra
import com.google.firebase.database.FirebaseDatabase

class InserirNotasActivity : AppCompatActivity() {

    var tituloDaMusica: TextView? = null
    var nomeDoArtista: TextView? = null
    var letraDaMusica: TextView? = null
    var nTom: TextView? = null

    var dataSaved = false
    lateinit var id: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inserir_notas)

        nTom = findViewById(R.id.textViewTom)

        tituloDaMusica = findViewById(R.id.textViewTitulo)
        nomeDoArtista = findViewById(R.id.textViewArtista)
        letraDaMusica = findViewById(R.id.editViewLetra)

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

        tituloDaMusica?.text = bundle!!.getString("nomeMusica", "Default")
        nomeDoArtista?.text = bundle!!.getString("nomeArtista", "Default")
        letraDaMusica?.text = bundle!!.getString("letraMusica", "Default")

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

        var btnSalvarArquivo: Button? = null
        btnSalvarArquivo = findViewById(R.id.btnSalvarArquivo)
        btnSalvarArquivo?.setOnClickListener{
            salvarCifra()
        }

    }

    fun salvarCifra(){

        val cifra = Cifra(tituloDaMusica, nomeDoArtista, letraDaMusica, nTom)

        val database = FirebaseDatabase.getInstance()
        val reference = database.getReference("cifras")

        val key = reference.push().key

        if (key != null) {
            reference.child(key).setValue(cifra) { error, ref ->
                val message = ProgressDialog(this)
                message.setTitle("Aguarde")
                message.setMessage("Salvando dados...")
                message.show()
                if (error == null) {
                    dataSaved = true
                    message.dismiss()
                }
            }
        }

        val bundle2 = Bundle()
        bundle2.putString("tituloMusica", tituloDaMusica.toString())
        bundle2.putString("nomeArtista", nomeDoArtista.toString())
        bundle2.putString("letraMusica", letraDaMusica.toString())
        bundle2.putString("tom", nTom.toString())

        key.let {
            bundle2.putString("id", key)
        }

        intent = Intent(this, VisualizarCifraActivity::class.java)
        intent.putExtras(bundle2)
        startActivity(intent)

/*
        fun clickNote(view: View) {
            Toast.makeText(this, ((view) as TextView).text, Toast.LENGTH_SHORT).show()
        }
*/
    }

/*
    fun voltarEdicao(view: View) {
        val intent = Intent(this, CriarCifraActivity::class.java)
        startActivity(intent)

    }
*/
}
