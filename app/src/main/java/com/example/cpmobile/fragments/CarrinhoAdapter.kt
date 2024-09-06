package com.example.cpmobile.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cpmobile.R
import com.example.cpmobile.fragments.Produto

class CarrinhoAdapter(private val itens: List<Produto>) :
    RecyclerView.Adapter<CarrinhoAdapter.CarrinhoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarrinhoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_carrinho, parent, false)
        return CarrinhoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarrinhoViewHolder, position: Int) {
        val item = itens[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = itens.size

    class CarrinhoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Produto) {
            val nomeProduto = itemView.findViewById<TextView>(R.id.textViewNomeProduto)
            val precoProduto = itemView.findViewById<TextView>(R.id.textViewPrecoProduto)
            val imagemProduto = itemView.findViewById<ImageView>(R.id.imageViewProduto)

            nomeProduto.text = item.nome
            precoProduto.text = "R$ %.2f".format(item.preco)
            imagemProduto.setImageResource(item.imagemResId)
        }
    }
}
