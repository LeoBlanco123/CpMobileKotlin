package com.example.cpmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.cpmobile.fragments.HomeFragment
import com.example.cpmobile.fragments.CarrinhoFragment
import com.example.cpmobile.fragments.CameraFragment
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<CurvedBottomNavigation>(R.id.bottomNavigation)
        bottomNavigation.add(
            CurvedBottomNavigation.Model(1, "Home", R.drawable.home)
        )
        bottomNavigation.add(
            CurvedBottomNavigation.Model(2, "Carrinho", R.drawable.bag)
        )
        bottomNavigation.add(
            CurvedBottomNavigation.Model(3, "Integrantes", R.drawable.camera)
        )

        bottomNavigation.setOnClickMenuListener {
            when(it.id){
                1 -> {
                    replaceFragment(HomeFragment())
                }
                2 -> {
                    replaceFragment(CarrinhoFragment())
                }
                3 -> {
                    replaceFragment(CameraFragment())
                }
            }
        }

        replaceFragment(HomeFragment())
        bottomNavigation.show(1)
    }

    // Coloque a função replaceFragment aqui
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
