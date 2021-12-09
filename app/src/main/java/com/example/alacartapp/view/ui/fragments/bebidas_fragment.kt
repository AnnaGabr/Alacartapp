package com.example.alacartapp.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alacartapp.R
import com.example.alacartapp.view.ui.activities.ProductsModel
import com.example.alacartapp.view.ui.activities.RecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_bebidas.*
import kotlinx.android.synthetic.main.fragment_hamburguers.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [bebidas_fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class bebidas_fragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_bebidas, container, false)
    }

    override fun onResume() {
        super.onResume()
        fromBebidasToHamburguesa.setOnClickListener{
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContent, HamburguersFragment()).commit()
        }

        fromBebidasToPizza.setOnClickListener{
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContent, pizza_fragmet()).commit()
        }

        fromBebidasToPedido.setOnClickListener{
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContent, Pedido()).commit()
        }
        //// --------- Recycler View Implementation -----------////
        val recycler : RecyclerView = requireActivity().findViewById(R.id.rvMainActivity)
        val adapter : RecyclerViewAdapter = RecyclerViewAdapter()


        //Configuracón del Adapter
        adapter.RecyclerViewAdapter(products(), context = requireContext())

        // Configuración del recycler View
        recycler.hasFixedSize()
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter
        //// --------- End of Recycler View Implementation -----------////
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment bebidas_fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            bebidas_fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    //// --------- Hardcode Products Info -----------////
    private fun products(): MutableList<ProductsModel>{
        var productsModels : MutableList<ProductsModel> = ArrayList()
        productsModels.add(
            ProductsModel(R.drawable.limonada,"Bebida 1",
                "Totalmente natural, con limones traídos de la mejor tierra calida," +
                    " disfrutarás del mejor sabor acido que has sentido en la vida, además, es de las mejores opciones para refrescarte" +
                    " y lo mejor de todo, saludablemente.\n", "$ 9.900")
        )

        productsModels.add(
            ProductsModel(R.drawable.jugo_natural,"Bebida 2",
                "Puedes elegir la fruta que desees, tambien si quieres este jugo en leche o agua, tenemos una gran variedad para satisfacer a todos nuestros clientes.",
                "$ 12.900")
        )

        productsModels.add(
            ProductsModel(R.drawable.gaseosa,"Bebida 3",
                " De la marca y sabor que desees, tenemos todas las gaseosas disponibles para tu disfrute, en excelente acompañamiento para nuestras comidas.",
                "$ 14.900")
        )


        return productsModels
    }
    //// --------- End of Hardcode Products Info -----------////

}