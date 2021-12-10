package com.example.alacartapp.view.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alacartapp.R
import com.example.alacartapp.models.ProductsModel
import com.example.alacartapp.adapters.RecyclerViewAdapter
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_hamburguers.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HamburguersFragment : Fragment() {

    private lateinit var db : FirebaseFirestore
    private lateinit var hamburguesasRecyclerView : RecyclerView
    private lateinit var hamburgesaArrayList : ArrayList<ProductsModel>


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

        //// --------- Recycler View Implementation -----------////
        hamburguesasRecyclerView = requireActivity().findViewById(R.id.rvMainActivity)
        hamburguesasRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        hamburguesasRecyclerView.setHasFixedSize(true)

        hamburgesaArrayList = arrayListOf<ProductsModel>()
        getHamburguesaData()


    }

    private fun getHamburguesaData() {
        db = FirebaseFirestore.getInstance()
        val docRef = db.collection("hamburguesas")
        docRef.get().addOnCompleteListener{ task ->
            if (task.isSuccessful){
                val doc = task.result
                if (doc != null) {
                    for (bs in doc){
                        val hamburguesa = ProductsModel(bs.reference.id,
                            bs.get("imagen").toString(),
                            bs.get("nombre").toString(),
                            bs.get("descripcion").toString(),
                            bs.get("precio").toString())
                        Log.d("MYTAG", "se encontro hamburguesa" +bs.get("nombre").toString())
                        hamburgesaArrayList.add(hamburguesa)

                    }
                    var newadapter = RecyclerViewAdapter(hamburgesaArrayList)
                    hamburguesasRecyclerView.adapter =  newadapter
                    newadapter.onItemClickListener(object: RecyclerViewAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {
                            var itemSelected = hamburgesaArrayList[position]
                            Toast.makeText(activity, "Se agregó al carrito ${itemSelected.nombre}",
                                Toast.LENGTH_SHORT).show()
                        }
                    })
                }
            }

        }
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

}