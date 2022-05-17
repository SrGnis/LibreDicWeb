package com.srgnis.libredicweb.query;

import java.util.List;

import com.srgnis.libredicweb.postobjects.QueryPOSTBody;

public class QueryBuilder{
	
	public static String GenerateQuerry(QueryPOSTBody postBody) {
		String querry = QueryParts.DEFAULT_BODY;
		String categorias = null;
		String propiedades = null;
		
		if (postBody.categorias == null) {
			categorias = QueryParts.DEFAULT_CATEGORIAS;
		}else {
			categorias = String.format(QueryParts.SELECTED_CATEGORIAS, postBody.categorias.get(0), FillCategorias(1, postBody.categorias));
		}
		
		return String.format(querry, postBody.lema, categorias, "");
	}
	
	private static String FillCategorias(int array_index, List<String> categorias) {
		if(array_index >= categorias.size()) {
			return "";
		}
		
		return String.format(QueryParts.ANOTHER_CATEGORIA, categorias.get(array_index), FillCategorias( array_index+1, categorias));
	}

}
