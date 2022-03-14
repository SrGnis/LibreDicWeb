package com.srgnis.libredicweb.models;

public class Caracteristicas {
    private long id;
    private long id_sentido;
    private long id_categoria;
    private Categoria categoria;
    private Propiedad[] propiedades;

    public Caracteristicas(long id, long id_sentido, long id_categoria) {
        this.id = id;
        this.id_sentido = id_sentido;
        this.id_categoria = id_categoria;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_sentido() {
        return id_sentido;
    }

    public void setId_sentido(long id_sentido) {
        this.id_sentido = id_sentido;
    }

    public long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(long id_categoria) {
        this.id_categoria = id_categoria;
    }

    @Override
    public String toString() {
        return "Caracteristicas{" +
                "id=" + id +
                ", id_sentido=" + id_sentido +
                ", id_categoria=" + id_categoria +
                '}';
    }
}
