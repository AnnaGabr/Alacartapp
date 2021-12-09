package com.example.alacartapp.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alacartapp.R
import com.example.alacartapp.models.ProductsModel
import com.example.alacartapp.adapters.RecyclerViewAdapter
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_bebidas.*
import android.util.Log
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

    //private lateinit var dbref : DatabaseReference
    private lateinit var db : FirebaseFirestore
    private lateinit var bebidasRecyclerView : RecyclerView
    private lateinit var bebidaArrayList : ArrayList<ProductsModel>


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
        bebidasRecyclerView = requireActivity().findViewById(R.id.rvMainActivity)
        bebidasRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        bebidasRecyclerView.setHasFixedSize(true)

        bebidaArrayList = arrayListOf<ProductsModel>()
        getBebidaData()

    }

    private fun getBebidaData() {
        /*dbref = FirebaseDatabase.getInstance().getReference("bebidas")
        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (bebidaSnaphot in snapshot.children){
                        val bebida = bebidaSnaphot.getValue(ProductsModel::class.java)
                        bebidaArrayList.add(bebida!!)
                    }
                }
                bebidasRecyclerView.adapter =  RecyclerViewAdapter(bebidaArrayList)
            }

            override fun onCancelled(error: DatabaseError) {

            }


        })*/
        db = FirebaseFirestore.getInstance()
        val docRef = db.collection("bebidas")
        docRef.get().addOnCompleteListener{ task ->
            if (task.isSuccessful){
                val doc = task.result
                if (doc != null) {
                    for (bs in doc){
                        val bebida = ProductsModel(bs.get("imagen").toString(),bs.get("nombre").toString(), bs.get("descripcion").toString(),bs.get("precio").toString())
                        Log.d("MYTAG", "se encontro bebida" +bs.get("nombre").toString())
                        bebidaArrayList.add(bebida)

                    }
                    bebidasRecyclerView.adapter =  RecyclerViewAdapter(bebidaArrayList)
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


}