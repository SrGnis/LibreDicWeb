package com.srgnis.libredicweb;

import com.srgnis.libredicweb.models.Palabra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
public class MainController {
    String info_querry=
            "SELECT pal.id AS palabra_id pal.lema, s.id AS id_sentido, cat.tipo_categoria AS categoria, tp.tipo_propiedad_entero AS propiedad, pro.valor \n" +
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
/*
    @GetMapping(path="/all_palabras")
    public String getAllPalabras() {
        String returntxt = jdbcTemplate.query(
                "SELECT id, lema FROM palabras",
                (rs, rowNum) -> new Palabra(rs.getLong("id"), rs.getString("lema"))
        ).stream().map(p -> p.toString()+ '\n').collect(Collectors.joining());
        return returntxt;
    }*/
    @GetMapping(path="/palabra")
    public String getPalabra(@RequestParam String lema) {
        String returntxt = jdbcTemplate.query(
                String.format(info_querry, lema),
                (rs, rowNum) -> new Palabra(rs.getLong("palabra_id"), rs.getString("lema"))
        ).stream().map(p -> p.toString() + '\n').collect(Collectors.joining());
        return returntxt;
    }
}