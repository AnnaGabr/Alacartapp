package com.example.alacartapp.view.ui.activities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alacartapp.R
import com.squareup.picasso.Picasso

class RecyclerViewAdapter(private val productList : ArrayList<ProductsModel>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.products_card_view_layout,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentView = productList[position]

        holder.nombreProducto.text  = currentView.nombre
        holder.descripcionProducto.text  = currentView.descripcion
        holder.precioProducto.text = currentView.precio
        Picasso.get().load(currentView.imagen).into(holder.imagenProducto)
    }

    override fun getItemCount(): Int{
        return productList.size
    }

    class ViewHolder (itemview: View):RecyclerView.ViewHolder(itemview) {

        val nombreProducto:TextView
        val descripcionProducto:TextView
        val precioProducto:TextView
        val imagenProducto: ImageView

        init {
            nombreProducto = itemview.findViewById(R.id.tvProductName)
            descripcionProducto = itemview.findViewById(R.id.tvProductDescription)
            precioProducto = itemview.findViewById(R.id.tvProductPrice)
            imagenProducto = itemview.findViewById(R.id.iv_Products)
        }
    }
}