package com.example.cpmobile.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cpmobile.R

class HomeFragment : Fragment() {

    private val produtos = listOf(
        Produto("Camisa", 59.99, R.drawable.camisa),
        Produto("Calça", 29.99, R.drawable.calca),
        Produto("Meia", 19.99, R.drawable.meia),
        Produto("Tenis", 249.99, R.drawable.tenis),
        Produto("Bone", 89.99, R.drawable.bone)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate o layout para este fragmento
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Inicialize o RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ProdutoAdapter(produtos)

        return view
    }
}

data class Produto(val nome: String, val preco: Double, val imagemResId: Int)

class ProdutoAdapter(private val produtos: List<Produto>) :
    RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_produto, parent, false)
        return ProdutoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val produto = produtos[position]
        holder.bind(produto)
    }

    override fun getItemCount(): Int = produtos.size

    class ProdutoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(produto: Produto) {
            val nomeProduto = itemView.findViewById<TextView>(R.id.textViewProduto)
            val precoProduto = itemView.findViewById<TextView>(R.id.textViewPreco)
            val imagemProduto = itemView.findViewById<ImageView>(R.id.imageViewProduto)
            val botaoAdicionar = itemView.findViewById<Button>(R.id.buttonAdicionar)

            nomeProduto.text = produto.nome
            precoProduto.text = "R$ %.2f".format(produto.preco)
            imagemProduto.setImageResource(produto.imagemResId)
        }
    }
}
