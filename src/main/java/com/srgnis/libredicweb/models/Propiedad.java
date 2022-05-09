package com.srgnis.libredicweb.models;

import com.srgnis.libredicweb.Foo;
import com.srgnis.libredicweb.Verboser;

//TODO creacción con un valor/propiedad null o no existente
public class Propiedad {
    private String propiedad;
    private String propiedad_v;
    private String valor;
    private String valor_v;
    @Foo
    private Caracteristicas caracteristicas;

    public Propiedad(String propiedad, String valor, Caracteristicas caracteristicas) {
    	this.caracteristicas = caracteristicas;
        this.propiedad = propiedad;
        this.propiedad_v = Verboser.propiedad.get(propiedad);
        this.valor = valor;
        this.valor_v = Verboser.valor.get(caracteristicas.getCategoria()+propiedad+valor);
    }

    public String getPropiedad(boolean verbose) {
    	if(verbose) {
    		return propiedad_v;
    	}else {
    		return propiedad;
    	}
    }

    public String getValor(boolean verbose) {
    	if(verbose) {
    		return valor_v;
    	}else {
    		return valor;
    	}
    }

    public void setPropiedad(String propiedad) {
        this.propiedad = propiedad;
        this.propiedad_v = Verboser.propiedad.get(propiedad);
    }

    public void setValor(String valor) {
        this.valor = valor;
        this.valor_v = Verboser.valor.get(caracteristicas.getCategoria()+propiedad+valor);
    }

	@Override
	public String toString() {
		return "Propiedad [propiedad=" + propiedad + ", propiedad_v=" + propiedad_v + ", valor=" + valor + ", valor_v="
				+ valor_v + "]";
	}

    
}
