package com.example.alacartapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alacartapp.R
import com.example.alacartapp.models.ProductsModel
import com.squareup.picasso.Picasso

class RecyclerViewAdapter(private val productList : ArrayList<ProductsModel>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun onItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.products_card_view_layout,parent,false)
        return ViewHolder(itemView, mListener)
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

    class ViewHolder (itemview: View, listener: onItemClickListener):RecyclerView.ViewHolder(itemview) {

        val nombreProducto:TextView
        val descripcionProducto:TextView
        val precioProducto:TextView
        val imagenProducto: ImageView

        init {
            nombreProducto = itemview.findViewById(R.id.tvProductName)
            descripcionProducto = itemview.findViewById(R.id.tvProductDescription)
            precioProducto = itemview.findViewById(R.id.tvProductPrice)
            imagenProducto = itemview.findViewById(R.id.iv_Products)

            itemview.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}