package com.srgnis.libredicweb.models;

import java.util.ArrayList;
import java.util.Arrays;

public class Caracteristicas {
    private String categoria;
    public ArrayList<Propiedad> propiedades;

    public Caracteristicas(String categoria) {
        this.categoria = categoria;
        this.propiedades = new ArrayList<>();
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Caracteristicas{" +
                "categoria=" + categoria +
                ", propiedades=" + propiedades +
                '}';
    }
}
