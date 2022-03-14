package com.srgnis.libredicweb.models;

public class Palabra {
    private long id;
    private String lema;
    private Sentido sentido;

    public Palabra(long id,String lema) {
        this.id = id;
        this.lema = lema;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setLema(String lema){
        this.lema = lema;
    }

    public long getId() {
        return id;
    }

    public String getLema() {
        return lema;
    }


    @Override
    public String toString() {
        return "Palabra{" +
                "id=" + id +
                ", lema='" + lema + '\'' +
                '}';
    }
}
