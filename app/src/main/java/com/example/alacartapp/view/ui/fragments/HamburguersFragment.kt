package com.example.alacartapp.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alacartapp.R
import com.example.alacartapp.view.ui.activities.ProductsModel
import com.example.alacartapp.view.ui.activities.RecyclerViewAdapter
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_bebidas.*
import kotlinx.android.synthetic.main.fragment_hamburguers.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HamburguersFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hamburguers, container, false)
    }

    override fun onResume() {
        super.onResume()
        fromHamburgersaToPizza.setOnClickListener{
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContent, pizza_fragmet()).commit()
        }

        fromHamburgersaToBebidas.setOnClickListener{
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContent, bebidas_fragment()).commit()
        }

        fromHamburguesaToPedido.setOnClickListener{
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContent, Pedido()).commit()
        }

        /// Recycler View Implementation
        val recycler : RecyclerView = requireActivity().findViewById(R.id.rvMainActivity)
        val adapter : RecyclerViewAdapter = RecyclerViewAdapter()


        //Configuracón del Adapter
        adapter.RecyclerViewAdapter(products(), context = requireContext())

        // Configuración del recycler View
        recycler.hasFixedSize()
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter


    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HamburguersFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun products(): MutableList<ProductsModel>{
        var productsModels : MutableList<ProductsModel> = ArrayList()
        productsModels.add(
            ProductsModel("La Todo Terreno", "Haburguesa con 125g de carne de res" +
                "+huevo+pan de papa + Gaseosa + Papas")
        )
        productsModels.add(
            ProductsModel("Cuarto de libra", "Haburguesa con 500g de carne de Cerdo+huevo+pan de papa+ Gaseosa + Papas" +
                "Haburguesa con 500g de carne de Cerdo+huevo+pan de papa+ Gaseosa + Papas" +
                "Haburguesa con 500g de carne de Cerdo+huevo+pan de papa+ Gaseosa + Papas   ")
        )
        productsModels.add(ProductsModel("Wrapper", "Haburguesa con 50g de carne de pavo+huevo+pan de papa+ Gaseosa + Papas"))
        productsModels.add(
            ProductsModel("La Todo Terreno", "Haburguesa con 125g de carne de res" +
                "+huevo+pan de papa + Gaseosa + Papas")
        )
        productsModels.add(
            ProductsModel("Cuarto de libra", "Haburguesa con 500g de carne de Cerdo+huevo+pan de papa+ Gaseosa + Papas" +
                "Haburguesa con 500g de carne de Cerdo+huevo+pan de papa+ Gaseosa + Papas" +
                "Haburguesa con 500g de carne de Cerdo+huevo+pan de papa+ Gaseosa + Papas   ")
        )
        productsModels.add(ProductsModel("Wrapper", "Haburguesa con 50g de carne de pavo+huevo+pan de papa+ Gaseosa + Papas"))
        productsModels.add(
            ProductsModel("La Todo Terreno", "Haburguesa con 125g de carne de res" +
                "+huevo+pan de papa + Gaseosa + Papas")
        )
        productsModels.add(
            ProductsModel("Cuarto de libra", "Haburguesa con 500g de carne de Cerdo+huevo+pan de papa+ Gaseosa + Papas" +
                "Haburguesa con 500g de carne de Cerdo+huevo+pan de papa+ Gaseosa + Papas" +
                "Haburguesa con 500g de carne de Cerdo+huevo+pan de papa+ Gaseosa + Papas   ")
        )
        productsModels.add(ProductsModel("Wrapper", "Haburguesa con 50g de carne de pavo+huevo+pan de papa+ Gaseosa + Papas"))
        productsModels.add(
            ProductsModel("La Todo Terreno", "Haburguesa con 125g de carne de res" +
                "+huevo+pan de papa + Gaseosa + Papas")
        )
        productsModels.add(
            ProductsModel("Cuarto de libra", "Haburguesa con 500g de carne de Cerdo+huevo+pan de papa+ Gaseosa + Papas" +
                "Haburguesa con 500g de carne de Cerdo+huevo+pan de papa+ Gaseosa + Papas" +
                "Haburguesa con 500g de carne de Cerdo+huevo+pan de papa+ Gaseosa + Papas   ")
        )
        productsModels.add(ProductsModel("Wrapper", "Haburguesa con 50g de carne de pavo+huevo+pan de papa+ Gaseosa + Papas"))
        return productsModels
    }

}