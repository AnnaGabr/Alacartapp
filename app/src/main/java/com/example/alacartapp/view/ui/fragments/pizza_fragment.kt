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
import kotlinx.android.synthetic.main.fragment_pizza.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [pizza_fragmet.newInstance] factory method to
 * create an instance of this fragment.
 */
class pizza_fragmet : Fragment() {
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
        return inflater.inflate(R.layout.fragment_pizza, container, false)
    }

    override fun onResume() {
        super.onResume()
        fromPizzaToBebidas.setOnClickListener{
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContent, bebidas_fragment()).commit()
        }

        fromPizzaToHamburger.setOnClickListener{
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContent, HamburguersFragment()).commit()
        }

        fromPizzaToPedido.setOnClickListener{
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
         * @return A new instance of fragment pizza_fragmet.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            pizza_fragmet().apply {
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
            ProductsModel(R.drawable.pizza_pollo,"Pizza 1",
                "pizza con pollo, pollo con pizza," +
                    " una combinación simple, segura y exquisita, pero si a esta pizza le sumamos la deliciosa salsa BBQ" +
                    " hecha en casa, también te comerás tus dedos.\n",
                "$ 24.900")
        )

        productsModels.add(
            ProductsModel(R.drawable.pizza_hawaiana,"Pizza 2",
                "Llegó la hora de la polémica, amada por unos, odiada por otros... lo importante es que si pruebas nuestra pizza hawaiana, solo te quedará la opción de amarla.",
                "$ 22.900")
        )

        productsModels.add(
            ProductsModel(R.drawable.pizza_vegetariana,"Pizza 3",
                "Tal vez la pizza mas saludable que probarás nunca, hecha con ingredientes seleccionados que cautivarán tu paladar y te harán devorar las 8 porciones.",
                "$ 25.900")
        )


        return productsModels
    }
    //// --------- End of Hardcode Products Info -----------////
}