package com.srgnis.libredicweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class LibredicWebApplication implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(LibredicWebApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LibredicWebApplication.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {
        log.info("Querying for plabras records where lema = 'casa':");
        jdbcTemplate.query(
            "SELECT id, lema FROM palabras WHERE lema = ?",
            (rs, rowNum) -> new Palabra(rs.getLong("id"), rs.getString("lema")),
            "casa"
        ).forEach(palabra -> log.info(palabra.toString()));
    }
}
