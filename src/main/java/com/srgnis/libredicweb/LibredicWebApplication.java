package com.srgnis.libredicweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibredicWebApplication{
    public static final Logger log = LoggerFactory.getLogger(LibredicWebApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LibredicWebApplication.class, args);
    }

}
