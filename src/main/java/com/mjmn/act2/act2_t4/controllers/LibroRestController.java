package com.mjmn.act2.act2_t4.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mjmn.act2.act2_t4.dto.LibroDTO;

@RestController
public class LibroRestController {

    @PostMapping("/api/libros")
    public LibroDTO registrarLibro(@RequestBody LibroDTO libro) {

        return libro;

    }

}