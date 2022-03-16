package com.srgnis.libredicweb.models;

public class Propiedad {
    private String propiedad;
    private String valor;

    public Propiedad(String propiedad, String valor) {
        this.propiedad = propiedad;
        this.valor = valor;
    }

    public String getPropiedad() {
        return propiedad;
    }

    public String getValor() {
        return valor;
    }

    public void setPropiedad(String propiedad) {
        this.propiedad = propiedad;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Propiedad{" +
                "propiedad=" + propiedad +
                ", valor=" + valor +
                '}';
    }
}
