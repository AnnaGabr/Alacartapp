package com.example.alacartapp.view.ui

import android.content.Context
import com.example.alacartapp.view.ui.InterfaceNotImplementedException

fun <T> Context.shouldImplement(myInterface: Class<*>): T {
    if (myInterface.isAssignableFrom(this::class.java)) {
        return this as T
    } else {
        throw InterfaceNotImplementedException(
            this.getSimpleName(),
            myInterface.simpleName
        )
    }
}


fun Any.getSimpleName(): String {
    return this.javaClass.simpleName
}