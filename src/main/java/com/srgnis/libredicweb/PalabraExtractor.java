package com.srgnis.libredicweb;

import com.srgnis.libredicweb.models.Palabra;
import com.srgnis.libredicweb.models.Propiedad;
import com.srgnis.libredicweb.models.Sentido;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class PalabraExtractor implements ResultSetExtractor<Palabra> {
    @Override
    public Palabra extractData(ResultSet rs) throws SQLException, DataAccessException {
        System.out.println("start");

        Palabra p = null;
        Sentido s = null;
        HashMap<Long, Sentido> sentidoHashMap = new HashMap<>();

        while (rs.next()){
            if(p == null){
                p = new Palabra(rs.getString("lema"));
            }

            s = sentidoHashMap.get(rs.getLong("id_sentido"));
            if( s == null){
                s = new Sentido("", rs.getString("categoria"));//TODO retrieve sentido string
                sentidoHashMap.put(rs.getLong("id_sentido"), s);
                p.sentidos.add(s);
            }

            s.caracteristicas.propiedades.add( new Propiedad(rs.getString("propiedad"), rs.getString("valor")) );
        }
        return p;
    }
}
