package com.example.alacartapp.view.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alacartapp.R
import com.example.alacartapp.view.ui.activities.ProductsModel
import com.example.alacartapp.view.ui.activities.RecyclerViewAdapter
import com.google.firebase.firestore.FirebaseFirestore
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
    private lateinit var db : FirebaseFirestore
    private lateinit var pizzasRecyclerView : RecyclerView
    private lateinit var pizzaArrayList : ArrayList<ProductsModel>


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
        pizzasRecyclerView = requireActivity().findViewById(R.id.rvMainActivity)
        pizzasRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        pizzasRecyclerView.setHasFixedSize(true)

        pizzaArrayList = arrayListOf<ProductsModel>()
        getPizzaData()

    }

    private fun getPizzaData() {
        db = FirebaseFirestore.getInstance()
        val docRef = db.collection("pizzas")
        docRef.get().addOnCompleteListener{ task ->
            if (task.isSuccessful){
                val doc = task.result
                if (doc != null) {
                    for (bs in doc){
                        val pizza = ProductsModel(bs.get("imagen").toString(),bs.get("nombre").toString(), bs.get("descripcion").toString(),bs.get("precio").toString())
                        Log.d("MYTAG", "se encontro pizza" +bs.get("nombre").toString())
                        pizzaArrayList.add(pizza)

                    }
                    pizzasRecyclerView.adapter =  RecyclerViewAdapter(pizzaArrayList)
                }
            }

        }
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

}