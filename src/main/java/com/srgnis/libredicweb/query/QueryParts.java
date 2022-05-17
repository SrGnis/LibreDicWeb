package com.srgnis.libredicweb.query;

public class QueryParts {
	
	public static final String DEFAULT_BODY = 
			"SELECT pal.lema, s.id AS id_sentido, car.categoria, pro.propiedad, pro.valor \n"
			+ "FROM\n"
			+ "(\n"
			+ "    SELECT *\n"
			+ "    FROM palabras pal\n"
			+ "    WHERE pal.lema LIKE \"%s\"\n" //lema a buscar
			+ ") AS pal\n"
			+ "JOIN sentidos s ON s.id_palabra = pal.id\n"
			+ "JOIN %s car ON car.id_sentido = s.id\n" //categorias a las que pertenece
			+ "JOIN propiedades pro ON car.id = pro.id_caracteristicas\n"
			+ "%s;"; //propiedades que debe tener
	
	public static final String DEFAULT_CATEGORIAS = "SELECT * FROM caracteristicas";
	
	public static final String SELECTED_CATEGORIAS = "(SELECT * FROM caracteristicas WHERE categoria = \"%s\" %s)";
	
	public static final String ANOTHER_CATEGORIA = "OR categoria = \"%s\" %s";
	
	public static final String SELECTED_PROPIEDADES = 
			"JOIN\n"
			+ "(\n"
			+ "    SELECT pro.id_caracteristicas\n"
			+ "    FROM propiedades pro\n"
			+ "    WHERE %2$s\n"
			+ ") AS p%1$s ON car.id = p%1$s.id_caracteristicas\n";
	
	public static final String PROPIEDAD = "(propiedad = '%s' AND valor = '%s') %s"; 
	
	public static final String ANOTHER_PROPIEDAD = "OR (propiedad = '%s' AND valor = '%s') %s";


	
}
