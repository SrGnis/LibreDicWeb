package com.srgnis.libredicweb;

import com.srgnis.libredicweb.models.Palabra;
import com.srgnis.libredicweb.models.Propiedad;
import com.srgnis.libredicweb.models.Sentido;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class PalabraExtractor implements ResultSetExtractor<Palabra[]> {
    
    @Override
    public Palabra[] extractData(ResultSet rs) throws SQLException, DataAccessException {

        Palabra p = null;
        Sentido s;
        HashMap<String, Palabra> palabrasHashMap = new HashMap<>();
        HashMap<Long, Sentido> sentidoHashMap = new HashMap<>();

        int cont = 0;
        while (rs.next()){
        	p = palabrasHashMap.get(rs.getString("lema"));
            if(p == null){
                p = new Palabra(rs.getString("lema"));
                palabrasHashMap.put(rs.getString("lema"), p);
            }

            s = sentidoHashMap.get(rs.getLong("id_sentido"));
            if( s == null){
                s = new Sentido( String.valueOf(cont), rs.getString("categoria"));
                sentidoHashMap.put(rs.getLong("id_sentido"), s);
                p.sentidos.add(s);
                cont++;
            }

            s.caracteristicas.propiedades.add(new Propiedad(rs.getString("propiedad"), rs.getString("valor"), s.caracteristicas));
        }
        return palabrasHashMap.values().toArray(new Palabra[palabrasHashMap.values().size()]);
    }
}
