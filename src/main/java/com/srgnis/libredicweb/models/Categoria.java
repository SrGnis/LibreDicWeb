package com.srgnis.libredicweb.models;

public class Categoria {
    private long id;
    private char tipo_categoria;
    private String tipo_categoria_entero;

    public Categoria(long id, char tipo_categoria, String tipo_categoria_entero) {
        this.id = id;
        this.tipo_categoria = tipo_categoria;
        this.tipo_categoria_entero = tipo_categoria_entero;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public char getTipo_categoria() {
        return tipo_categoria;
    }

    public void setTipo_categoria(char tipo_categoria) {
        this.tipo_categoria = tipo_categoria;
    }

    public String getTipo_categoria_entero() {
        return tipo_categoria_entero;
    }

    public void setTipo_categoria_entero(String tipo_categoria_entero) {
        this.tipo_categoria_entero = tipo_categoria_entero;
    }

    @Override
    public String toString() {
        return "Categorias{" +
                "id=" + id +
                ", tipo_categoria=" + tipo_categoria +
                ", tipo_categoria_entero='" + tipo_categoria_entero + '\'' +
                '}';
    }
}
