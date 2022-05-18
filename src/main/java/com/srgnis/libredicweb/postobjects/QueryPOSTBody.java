package com.srgnis.libredicweb.postobjects;

import java.util.List;
//TODO Refactorizar variables para que sean mas descriptivos
public class QueryPOSTBody {
	public String lema;
	public List<String> categorias;
	public List<PropiedadesPOSTList> propiedades;
	public boolean verbose;
	public boolean ignorar_acentos;
	public boolean not_categorias;
}
