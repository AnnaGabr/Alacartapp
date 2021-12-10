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
import com.example.alacartapp.adapters.RecyclerViewAdapter
import com.example.alacartapp.models.ProductsModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Pedido.newInstance] factory method to
 * create an instance of this fragment.
 */
class Pedido : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var pedidoRecyclerView : RecyclerView
    private lateinit var carrito : ArrayList<ProductsModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            carrito = it.getParcelableArrayList(ARG_PARAM1)!!
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pedido, container, false)
    }

    override fun onResume() {
        super.onResume()

        pedidoRecyclerView = requireActivity().findViewById(R.id.rvMainActivity)
        pedidoRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        pedidoRecyclerView.setHasFixedSize(true)

        getPedidoData(carrito)
    }

    private fun getPedidoData(carrito: ArrayList<ProductsModel>){
        var newadapter = RecyclerViewAdapter(carrito)
        pedidoRecyclerView.adapter = newadapter
        newadapter.onItemClickListener(object : RecyclerViewAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                var itemSelected = carrito[position]
                Toast.makeText(activity, "${itemSelected.nombre} vale ${itemSelected.precio}",
                    Toast.LENGTH_SHORT).show()
            }
        })
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Pedido.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(carrito: ArrayList<ProductsModel>) =
            Pedido().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(ARG_PARAM1, carrito)
                }
            }
    }
}