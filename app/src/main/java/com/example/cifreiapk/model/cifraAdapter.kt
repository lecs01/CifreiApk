package com.example.cifreiapk.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cifreiapk.R


class CifraAdapter(val context: Context, val listCifras: MutableList<Cifra?>) :
    RecyclerView.Adapter<CifraAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CifraAdapter.ViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.recycler_view_cifras, parent, false)
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: CifraAdapter.ViewHolder, position: Int) {
        holder.nomeArtista.text = listCifras[position]?.nomeArtista
        holder.tituloMusica.text = listCifras[position]?.nomeMusica
        holder.tom.text = listCifras[position]?.tomSelecionado
    }

    override fun getItemCount(): Int {
       return listCifras.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tituloMusica: TextView = itemView.findViewById(R.id.tvTituloDaMusica)
        val nomeArtista: TextView = itemView.findViewById(R.id.tvNomeDoArtista)
        val tom: TextView = itemView.findViewById(R.id.tvTom)
    }
}