package com.example.cifreiapk

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.cifreiapk.model.Cifra
import com.example.cifreiapk.utils.TextoUtils
import com.google.firebase.database.FirebaseDatabase

class CriarCifraActivity : AppCompatActivity() {

    var tomSelecionado: String = "C"
/*
    var dataSaved = false
    lateinit var id: String
*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.criar_cifra)


        val spinner: Spinner = findViewById(R.id.spinnerListaDeTons)
        ArrayAdapter.createFromResource(
            this,
            R.array.lista_de_tons_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long,
            ) {
                tomSelecionado = (view as TextView).text.toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                tomSelecionado = "C"
            }
        }

        var btnProximo: Button? = null
        btnProximo = findViewById(R.id.btnProximo)
        btnProximo?.setOnClickListener{
            proximaEdicao()
        }
    }

    fun proximaEdicao() {

        val nomeMusica: EditText? = findViewById(R.id.nomeMusica)
        val nomeArtista: EditText? = findViewById(R.id.nomeArtista)
        val letraMusica: EditText? = findViewById(R.id.letraMusica)

        if (nomeMusica?.text.toString().isEmpty() || nomeArtista?.text.toString()
                .isEmpty() || letraMusica?.text.toString().isEmpty()
        ) {
            Toast.makeText(this, "Insira os dados para criar a cifra!", Toast.LENGTH_SHORT).show()
        } else {
            val nomeMusicaValue = nomeMusica!!.text.toString()
            val nomeArtistaValue = nomeArtista!!.text.toString()
            val letraMusicaValue = TextoUtils.convertWithBlankLines(letraMusica!!.text.toString())

//            val cifra = Cifra(nomeMusica, nomeArtista, letraMusica, tomSelecionado)

            val bundle = Bundle()
            bundle.putString("nomeMusica", nomeMusicaValue)
            bundle.putString("nomeArtista", nomeArtistaValue)
            bundle.putString("letraMusica", letraMusicaValue)
            bundle.putString("tomSelecionado", tomSelecionado)

/*
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

            key.let {
                bundle.putString("id", key)
            }
*/

            intent = Intent(this, InserirNotasActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

/*
    fun voltarMain(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
*/
}
