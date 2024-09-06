package com.example.cpmobile.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cpmobile.R
import com.example.cpmobile.adapters.CarrinhoAdapter

class CarrinhoFragment : Fragment() {

    private val itensNoCarrinho = listOf(
        Produto("Camisa", 59.99, R.drawable.camisa),
        Produto("Calça", 29.99, R.drawable.calca)
        // Adicione mais itens conforme necessário
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_carrinho, container, false)

        val recyclerViewCarrinho = view.findViewById<RecyclerView>(R.id.recyclerViewCarrinho)
        recyclerViewCarrinho.layoutManager = LinearLayoutManager(context)
        recyclerViewCarrinho.adapter = CarrinhoAdapter(itensNoCarrinho)

        // Configurar o resumo dos valores (exemplo)
        val textViewSubtotal = view.findViewById<TextView>(R.id.textViewSubtotal)
        val textViewImpostos = view.findViewById<TextView>(R.id.textViewImpostos)
        val textViewTotal = view.findViewById<TextView>(R.id.textViewTotal)

        // Calcular e definir os valores do resumo
        val subtotal = itensNoCarrinho.sumOf { it.preco }
        val impostos = subtotal * 0.1 // Exemplo de 10% de impostos
        val total = subtotal + impostos

        textViewSubtotal.text = "Subtotal: R$ %.2f".format(subtotal)
        textViewImpostos.text = "Impostos: R$ %.2f".format(impostos)
        textViewTotal.text = "Total: R$ %.2f".format(total)

        // Configurar o botão para finalizar a compra
        val buttonFinalizarCompra = view.findViewById<Button>(R.id.buttonFinalizarCompra)
        buttonFinalizarCompra.setOnClickListener {
            // Lógica para finalizar a compra
            Toast.makeText(context, "Compra finalizada!", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}





