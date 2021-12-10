package com.example.alacartapp.view.ui

class InterfaceNotImplementedException(
    className: String?,
    interfaceName: String
) : ClassCastException(
    String.format("interface no implementada", className, interfaceName)
)
