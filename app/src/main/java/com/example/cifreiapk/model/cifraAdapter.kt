package com.example.cifreiapk.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cifreiapk.R
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

class cifraAdapter(
    options: FirebaseRecyclerOptions<Cifra>,
) : FirebaseRecyclerAdapter<Cifra, cifraAdapter.cifrasViewholder>(options) {
    override fun onBindViewHolder(
        holder: cifrasViewholder,
        position: Int, model: Cifra,
    ) {
        holder.tituloDaMusica.setText(model.tituloDaMusica.toString())
        holder.nomeDoArtista.setText(model.nomeDoArtista.toString())
        holder.nTom.setText(model.nTom.toString())
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): cifrasViewholder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_cifras, parent, false)
        return cifrasViewholder(view)
    }

    inner class cifrasViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var tituloDaMusica: TextView
        lateinit var nomeDoArtista: TextView
        lateinit var nTom: TextView

        init {
            tituloDaMusica = itemView.findViewById(R.id.tvTituloDaMusica)
            nomeDoArtista = itemView.findViewById(R.id.tvNomeDoArtista)
            nTom = itemView.findViewById(R.id.tvTom)
        }
    }
}