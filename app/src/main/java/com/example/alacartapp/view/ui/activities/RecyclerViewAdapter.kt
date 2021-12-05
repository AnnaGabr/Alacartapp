package com.example.alacartapp.view.ui.activities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alacartapp.R

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    var productos : MutableList<ProductsModel> = ArrayList()
    lateinit var context :Context

    fun RecyclerViewAdapter(productos:MutableList<ProductsModel>,context:Context){
        this.productos = productos
        this.context = context
    }

    class ViewHolder (view: View):RecyclerView.ViewHolder(view) {
        val nombreProducto:TextView
        val descripcionProducto:TextView

        init {
            nombreProducto = view.findViewById(R.id.tvProductName)
            descripcionProducto = view.findViewById(R.id.tvProductDescription)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.products_card_view_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombreProducto.text  = productos[position].nombreProducto
        holder.descripcionProducto.text  = productos[position].descripcionProducto
    }

    override fun getItemCount() = productos.size
}