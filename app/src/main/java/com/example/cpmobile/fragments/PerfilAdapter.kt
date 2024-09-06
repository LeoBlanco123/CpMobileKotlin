package com.example.cpmobile.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cpmobile.R

data class Perfil(val nome: String, val fotoResId: Int)

class PerfilAdapter(private val perfis: List<Perfil>) :
    RecyclerView.Adapter<PerfilAdapter.PerfilViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerfilViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_perfil, parent, false)
        return PerfilViewHolder(view)
    }

    override fun onBindViewHolder(holder: PerfilViewHolder, position: Int) {
        val perfil = perfis[position]
        holder.bind(perfil)
    }

    override fun getItemCount(): Int = perfis.size

    class PerfilViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(perfil: Perfil) {
            val nome = itemView.findViewById<TextView>(R.id.textViewNome)
            val foto = itemView.findViewById<ImageView>(R.id.imageViewFoto)

            nome.text = perfil.nome
            foto.setImageResource(perfil.fotoResId)
        }
    }
}
