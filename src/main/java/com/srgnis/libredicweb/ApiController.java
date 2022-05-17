package com.srgnis.libredicweb;

import com.google.gson.GsonBuilder;
import com.srgnis.libredicweb.gson.exclusionstrategy.SimpleExclusionStrategy;
import com.srgnis.libredicweb.gson.exclusionstrategy.VerboseExclusionStrategy;
import com.srgnis.libredicweb.postobjects.QueryPOSTBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;

@RestController
public class ApiController {
    String info_querry=
            "SELECT pal.id AS palabra_id, pal.lema, s.id AS id_sentido, car.categoria, pro.propiedad, pro.valor \n" +
            "FROM\n" +
            "(\n" +
            "    SELECT *\n" +
            "    FROM palabras pal\n" +
            "    WHERE pal.lema LIKE \"%s\"\n" +
            ") AS pal\n" +
            "JOIN sentidos s ON s.id_palabra = pal.id\n" +
            "JOIN caracteristicas car ON car.id_sentido = s.id\n" +
            "JOIN propiedades pro ON car.id = pro.id_caracteristicas";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public String index() {
        return "LibreDic";
    }
    
    
    //http://127.0.0.1:8080/api/palabra/?lema=casa
    @GetMapping(path="/api/palabra", params = "lema")
    public String getPalabra(@RequestParam String lema) {
        return doGetPalabra(lema, false);
    }
    
    
    //http://127.0.0.1:8080/api/palabra/?lema=casa&verbose=true
    @GetMapping(path="/api/palabra", params = {"lema", "verbose"})
    public String getPalabra(@RequestParam String lema, @RequestParam boolean verbose) {
        return doGetPalabra(lema, verbose);
    }
    
    //http://127.0.0.1:8080/api/build_query
    @PostMapping(path = "/api/build_query")
    public String buildQuery(@RequestBody QueryPOSTBody postBody){
		return null;
    }

    private String doGetPalabra(String lema, boolean verbose){
    	Gson gson = null;
    	
    	if(verbose) {
    		gson = new GsonBuilder().setPrettyPrinting().serializeNulls().setExclusionStrategies(new VerboseExclusionStrategy()).create();
    	}else {
    		gson = new GsonBuilder().setPrettyPrinting().serializeNulls().setExclusionStrategies(new SimpleExclusionStrategy()).create();
    	}
    
        return gson.toJson( jdbcTemplate.query(String.format(info_querry, lema), new PalabraExtractor()) );
    }

}