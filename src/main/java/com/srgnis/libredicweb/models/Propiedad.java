package com.srgnis.libredicweb.models;

public class Propiedad {
    private long id;
    private long id_tipo_propiedad;
    private char valor;
    private long id_caracteristicas;
    private Caracteristicas caracteristicas;

    public Propiedad(long id, long id_tipo_propiedad, char valor, long id_caracteristicas) {
        this.id = id;
        this.id_tipo_propiedad = id_tipo_propiedad;
        this.valor = valor;
        this.id_caracteristicas = id_caracteristicas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_tipo_propiedad() {
        return id_tipo_propiedad;
    }

    public void setId_tipo_propiedad(long id_tipo_propiedad) {
        this.id_tipo_propiedad = id_tipo_propiedad;
    }

    public char getValor() {
        return valor;
    }

    public void setValor(char valor) {
        this.valor = valor;
    }

    public long getId_caracteristicas() {
        return id_caracteristicas;
    }

    public void setId_caracteristicas(long id_caracteristicas) {
        this.id_caracteristicas = id_caracteristicas;
    }

    @Override
    public String toString() {
        return "Propiedad{" +
                "id=" + id +
                ", id_tipo_propiedad=" + id_tipo_propiedad +
                ", valor=" + valor +
                ", id_caracteristicas=" + id_caracteristicas +
                '}';
    }
}
