package com.srgnis.libredicweb.query;

public class QueryParts {
	
	public static final String DEFAULT_BODY = 
			"SELECT pal.lema, s.id AS id_sentido, car.categoria, pro.propiedad, pro.valor \n"
			+ "FROM\n"
			+ "(\n"
			+ "    SELECT *\n"
			+ "    FROM \n"
			+ "    (\n"
			+ "        SELECT p.id, p.lema %s, p.num_letras\n" //ignorar acentos
			+ "        FROM palabras p \n"
			+ "    ) pal\n" 
			+ "    WHERE pal.lema LIKE \"%s\" %s\n" //lema a buscar u numero de letras
			+ ") AS pal\n"
			+ "JOIN sentidos s ON s.id_palabra = pal.id\n"
			+ "JOIN %s car ON car.id_sentido = s.id\n" //categorias a las que pertenece
			+ "JOIN propiedades pro ON car.id = pro.id_caracteristicas\n"
			+ "%s;"; //propiedades que debe tener
	
	public static final String DEFAULT_CATEGORIAS = "(SELECT * FROM caracteristicas)";
	
	public static final String SELECTED_CATEGORIAS = "(SELECT * FROM caracteristicas WHERE %s (categoria = \"%s\" %s))";
	
	public static final String ANOTHER_CATEGORIA = "OR categoria = \"%s\" %s";
	
	public static final String SELECTED_PROPIEDADES = 
			"JOIN\n"
			+ "(\n"
			+ "    SELECT pro.id_caracteristicas\n"
			+ "    FROM propiedades pro\n"
			+ "    WHERE %2$s\n"
			+ ") AS p%1$s ON car.id = p%1$s.id_caracteristicas\n";
	
	public static final String PROPIEDAD = "((propiedad = '%s' AND %s valor = '%s') %s)"; 
	
	public static final String ANOTHER_PROPIEDAD = "OR (propiedad = '%s' AND %s valor = '%s') %s";
	
	public static final String IGNORAR_ACENTOS = "COLLATE utf8mb4_general_ci AS lema";

	public static final String NUM_LETRAS_NUMERO = "AND pal.num_letras = %s";
	
	public static final String NUM_LETRAS_MAX_MIN = "AND pal.num_letras BETWEEN %s AND %s";

	
}
