package com.srgnis.libredicweb;

import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;

@RestController
public class MainController {
    String info_querry=
            "SELECT pal.id AS palabra_id, pal.lema, s.id AS id_sentido, cat.tipo_categoria AS categoria, tp.tipo_propiedad AS propiedad, pro.valor \n" +
            "FROM\n" +
            "(\n" +
            "    SELECT *\n" +
            "    FROM palabras pal\n" +
            "    WHERE pal.lema = \"%s\"\n" +
            ") AS pal\n" +
            "JOIN sentidos s ON s.id_palabra = pal.id\n" +
            "JOIN caracteristicas car ON car.id_sentido = s.id\n" +
            "JOIN categorias cat ON car.id_categoria = cat.id\n" +
            "JOIN propiedades pro ON car.id = pro.id_caracteristicas \n" +
            "JOIN tipos_propiedades tp ON pro.id_tipo_propiedad = tp.id";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping(path="/api/palabra")
    public String getPalabra(@RequestParam String lema) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson( jdbcTemplate.query(String.format(info_querry, lema), new PalabraExtractor()) );
    }

}