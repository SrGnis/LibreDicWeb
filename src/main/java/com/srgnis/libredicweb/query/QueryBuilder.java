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
		String collate = "";
		String not_categorias = "";
		
		if(postBody.not_categorias) {
			not_categorias = "NOT";
		}
		
		if(postBody.ignorar_acentos) {
			collate = QueryParts.IGNORAR_ACENTOS;
		}
		
		if (postBody.categorias == null) {
			categorias = QueryParts.DEFAULT_CATEGORIAS;
		}else {
			categorias = String.format(QueryParts.SELECTED_CATEGORIAS, not_categorias, postBody.categorias.get(0), FillCategorias(1, postBody.categorias));
		}
		
		if(postBody.propiedades != null) {
			int cont = 0;
			for ( PropiedadesPOSTList propiedadList : postBody.propiedades) {
				String not_propiedades = "";
				if(propiedadList.not_propiedades) {
					not_propiedades = "NOT";
				}
				propiedades += String.format(QueryParts.SELECTED_PROPIEDADES, cont, String.format(QueryParts.PROPIEDAD, propiedadList.propiedad, not_propiedades, propiedadList.valor.get(0), FillPropiedades(1, propiedadList.valor, propiedadList.propiedad, not_propiedades)));
				cont++;
			}
		}
		
		return String.format(querry, collate, postBody.lema, categorias, propiedades);
	}
	
	private static String FillCategorias(int array_index, List<String> categorias) {
		if(array_index >= categorias.size()) {
			return "";
		}
		
		return String.format(QueryParts.ANOTHER_CATEGORIA, categorias.get(array_index), FillCategorias( array_index+1, categorias));
	}
	
	private static String FillPropiedades(int array_index, List<String> valores, String propiedad, String not_propiedades) {
		if(array_index >= valores.size()) {
			return "";
		}
		
		return String.format(QueryParts.ANOTHER_PROPIEDAD, propiedad, not_propiedades, valores.get(array_index), FillPropiedades( array_index+1, valores, propiedad, not_propiedades));
	}

}
