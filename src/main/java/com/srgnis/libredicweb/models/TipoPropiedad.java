package com.srgnis.libredicweb.models;

public class TipoPropiedad {
    private long id;
    private char tipo_propiedad;
    private String tipo_propiedad_entero;

    public TipoPropiedad(long id, char tipo_propiedad, String tipo_propiedad_entero) {
        this.id = id;
        this.tipo_propiedad = tipo_propiedad;
        this.tipo_propiedad_entero = tipo_propiedad_entero;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public char getTipo_propiedad() {
        return tipo_propiedad;
    }

    public void setTipo_propiedad(char tipo_propiedad) {
        this.tipo_propiedad = tipo_propiedad;
    }

    public String getTipo_propiedad_entero() {
        return tipo_propiedad_entero;
    }

    public void setTipo_propiedad_entero(String tipo_propiedad_entero) {
        this.tipo_propiedad_entero = tipo_propiedad_entero;
    }

    @Override
    public String toString() {
        return "TipoPropiedad{" +
                "id=" + id +
                ", tipo_propiedad=" + tipo_propiedad +
                ", tipo_propiedad_entero='" + tipo_propiedad_entero + '\'' +
                '}';
    }
}
