package com.srgnis.libredicweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;

@SpringBootApplication
public class LibredicWebApplication{
    public static final Logger log = LoggerFactory.getLogger(LibredicWebApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LibredicWebApplication.class, args);
    }

}
