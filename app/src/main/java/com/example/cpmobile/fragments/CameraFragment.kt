package com.example.cpmobile.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cpmobile.R
import com.example.cpmobile.adapters.Perfil
import com.example.cpmobile.adapters.PerfilAdapter

class CameraFragment : Fragment() {

    private val perfis = listOf(
        Perfil("Leonardo Blanco - Rm99119", R.drawable.blanco),
        Perfil("Paulo Henrique - Rm98082", R.drawable.paulo),
        Perfil("Gustavo Moreira - Rm97999", R.drawable.gustavo)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_camera, container, false)

        val recyclerViewPerfis = view.findViewById<RecyclerView>(R.id.recyclerViewPerfis)
        recyclerViewPerfis.layoutManager = LinearLayoutManager(context)
        recyclerViewPerfis.adapter = PerfilAdapter(perfis)

        return view
    }
}
