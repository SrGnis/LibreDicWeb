package com.srgnis.libredicweb.query;

import java.util.List;

import com.srgnis.libredicweb.postobjects.PropiedadesPOSTList;
import com.srgnis.libredicweb.postobjects.QueryPOSTBody;

//TODO Refactorizar variables para que sean mas descriptivos
public class QueryBuilder{
	
	public static String GenerateQuerry(QueryPOSTBody postBody) {
		String querry = QueryParts.DEFAULT_BODY;
		String categorias = null;
		String propiedades = "";
		
		if (postBody.categorias == null) {
			categorias = QueryParts.DEFAULT_CATEGORIAS;
		}else {
			categorias = String.format(QueryParts.SELECTED_CATEGORIAS, postBody.categorias.get(0), FillCategorias(1, postBody.categorias));
		}
		
		if(postBody.propiedades != null) {
			int cont = 0;
			for ( PropiedadesPOSTList propiedadList : postBody.propiedades) {
				propiedades += String.format(QueryParts.SELECTED_PROPIEDADES, cont, String.format(QueryParts.PROPIEDAD, propiedadList.propiedad, propiedadList.valor.get(0), FillPropiedades(1, propiedadList.valor, propiedadList.propiedad)));
				cont++;
			}
		}
		
		return String.format(querry, postBody.lema, categorias, propiedades);
	}
	
	private static String FillCategorias(int array_index, List<String> categorias) {
		if(array_index >= categorias.size()) {
			return "";
		}
		
		return String.format(QueryParts.ANOTHER_CATEGORIA, categorias.get(array_index), FillCategorias( array_index+1, categorias));
	}
	
	private static String FillPropiedades(int array_index, List<String> valores, String propiedad) {
		if(array_index >= valores.size()) {
			return "";
		}
		
		return String.format(QueryParts.ANOTHER_PROPIEDAD, propiedad, valores.get(array_index), FillPropiedades( array_index+1, valores, propiedad));
	}

}
