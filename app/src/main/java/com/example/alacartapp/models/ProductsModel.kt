package com.example.alacartapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductsModel(
    var pk: String,
    var imagen: String,
    var nombre: String,
    var descripcion: String,
    var precio: String
): Parcelable
