package com.srgnis.libredicweb.models;

public class Sentido {
    private long id;
    private long id_palabra;
    private long id_raiz;
    private String sentido;
    private Caracteristicas caracteristicas;

    public Sentido(long id, long id_palabra, long id_raiz, String sentido) {
        this.id = id;
        this.id_palabra = id_palabra;
        this.id_raiz = id_raiz;
        this.sentido = sentido;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_palabra() {
        return id_palabra;
    }

    public void setId_palabra(long id_palabra) {
        this.id_palabra = id_palabra;
    }

    public long getId_raiz() {
        return id_raiz;
    }

    public void setId_raiz(long id_raiz) {
        this.id_raiz = id_raiz;
    }

    public String getSentido() {
        return sentido;
    }

    public void setSentido(String sentido) {
        this.sentido = sentido;
    }

    @Override
    public String toString() {
        return "Sentido{" +
                "id=" + id +
                ", id_palabra=" + id_palabra +
                ", id_raiz=" + id_raiz +
                ", sentido='" + sentido + '\'' +
                '}';
    }
}
