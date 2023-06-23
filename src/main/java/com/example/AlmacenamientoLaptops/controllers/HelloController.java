package com.example.AlmacenamientoLaptops.controllers;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Hidden
public class HelloController {

    @GetMapping("/saludo")
    public String saludar(){
        return "Hola, de sincero corazón, espero estés bien <3";
    }
}
