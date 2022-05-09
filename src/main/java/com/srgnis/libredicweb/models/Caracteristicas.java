package com.srgnis.libredicweb.models;

import java.util.ArrayList;

import com.srgnis.libredicweb.Verboser;

//TODO creacción con una categoria null o no existente
public class Caracteristicas {
    private String categoria;
    private String categoria_v;
    public ArrayList<Propiedad> propiedades;

    public Caracteristicas(String categoria) {
        this.categoria = categoria;
        this.propiedades = new ArrayList<>();
        this.categoria_v = Verboser.categoria.get(categoria);
    }
    
    public String getCategoria() {
    	return getCategoria(false);
    }

    public String getCategoria(boolean verbose) {
    	if(verbose) {
    		return categoria_v;
    	}else {
    		return categoria;
    	}
        
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
        this.categoria_v = Verboser.categoria.get(categoria);
    }

	@Override
	public String toString() {
		return "Caracteristicas [categoria=" + categoria + ", categoria_v=" + categoria_v + ", propiedades="
				+ propiedades + "]";
	}
    
}
