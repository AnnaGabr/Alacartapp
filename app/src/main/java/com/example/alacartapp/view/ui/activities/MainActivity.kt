package com.example.alacartapp.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.alacartapp.R
import com.example.alacartapp.databinding.ActivityMainBinding
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alacartapp.models.ProductsModel
import com.example.alacartapp.view.ui.fragments.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_bebidas.*
import kotlinx.android.synthetic.main.fragment_hamburguers.*
import kotlinx.android.synthetic.main.fragment_menu.*
import kotlinx.android.synthetic.main.fragment_pizza.*

class MainActivity : AppCompatActivity(), bebidas_fragment.BebidasListener {

    private lateinit var binding: ActivityMainBinding
    var carrito: MutableList<ProductsModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.bnavMenu?.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navMenu -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContent,
                        MenuFragment()).commit()
                    true
                }

                R.id.navOrder -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContent,
                        Pedido.newInstance(ArrayList(carrito))).commit()
                    true
                }

                else -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContent,
                        Waiter_login()).commit()
                    true
                }
            }
        }

        //override fun onItemClick(product: ProductsModel) {
        //    carrito.add(product)
        //}
    }

    override fun onBebidasSelect(bebida: ProductsModel) {
        carrito.add(bebida)
    }


}