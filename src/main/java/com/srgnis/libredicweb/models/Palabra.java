package com.srgnis.libredicweb.models;

import java.util.ArrayList;

public class Palabra {
    private String lema;
    public ArrayList<Sentido> sentidos;

    public Palabra(String lema) {
        this.lema = lema;
        this.sentidos = new ArrayList<>();
    }

    public void setLema(String lema){
        this.lema = lema;
    }

    public String getLema() {
        return lema;
    }

	@Override
	public String toString() {
		return "Palabra [lema=" + lema + ", sentidos=" + sentidos + "]";
	}

}
