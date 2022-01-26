package com.srgnis.libredicweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/libredic")
public class MainController {

    @PostMapping(path="/get")
    public @ResponseBody void getPalabra (@RequestParam String lema) {

    }

    @GetMapping(path="/all")
    public @ResponseBody void getAllPalabras() {

    }
}