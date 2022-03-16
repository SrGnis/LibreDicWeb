package com.srgnis.libredicweb.models;

public class Sentido {
    private String sentido;
    public Caracteristicas caracteristicas;

    public Sentido(String sentido) {
        this.sentido = sentido;
        this.caracteristicas = null;
    }

    public Sentido(String sentido, String cat) {
        this.sentido = sentido;
        this.caracteristicas = new Caracteristicas(cat);
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
                "sentido='" + sentido + '\'' +
                ", caracteristicas=" + caracteristicas +
                '}';
    }
}
