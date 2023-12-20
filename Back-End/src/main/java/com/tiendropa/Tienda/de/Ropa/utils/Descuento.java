package com.tiendropa.Tienda.de.Ropa.utils;

public class Descuento {

    public static double aplicarDescuento(double precio, double descuento) {
        return precio - (precio * (descuento / 100));
    }
}
