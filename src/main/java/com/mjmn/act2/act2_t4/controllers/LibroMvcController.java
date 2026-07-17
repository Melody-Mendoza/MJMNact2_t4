package com.mjmn.act2.act2_t4.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Value;

import com.mjmn.act2.act2_t4.dto.LibroDTO;

@Controller
public class LibroMvcController {

    @Value("${biblioteca.nombre}")
    private String nombreBiblioteca;

    @GetMapping("/libros")
    public String mostrarLibros(Model model) {

        List<LibroDTO> listaLibros = new ArrayList<>();

        listaLibros.add(new LibroDTO(1, "El Principito", "Antoine de Saint-Exupéry", "Infantil", 1943));
        listaLibros.add(new LibroDTO(2, "Matilda", "Roald Dahl", "Infantil", 1988));
        listaLibros.add(new LibroDTO(3, "El Grúfalo", "Julia Donaldson", "Infantil", 1999));
        listaLibros.add(new LibroDTO(4, "Coraline", "Neil Gaiman", "Fantasía", 2002));
        listaLibros.add(new LibroDTO(5, "Las Crónicas de Narnia", "C. S. Lewis", "Aventura", 1950));
        listaLibros.add(new LibroDTO(6, "Peter Pan", "J. M. Barrie", "Clásico", 1911));

        model.addAttribute("libros", listaLibros);

        return "catalogo";
    }

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {

        model.addAttribute("libro", new LibroDTO());

        return "formulario-libro";
    }

    @PostMapping("/guardarLibro")
    public String guardarLibro(@ModelAttribute LibroDTO libro, Model model) {

        model.addAttribute("libro", libro);

        return "resultado-libro";
    }

    @GetMapping("/buscar")
    public String buscarPorGenero(@RequestParam String genero, Model model) {

        List<LibroDTO> listaLibros = new ArrayList<>();

        listaLibros.add(new LibroDTO(1, "El Principito", "Antoine de Saint-Exupéry", "Infantil", 1943));
        listaLibros.add(new LibroDTO(2, "Matilda", "Roald Dahl", "Infantil", 1988));
        listaLibros.add(new LibroDTO(3, "El Grúfalo", "Julia Donaldson", "Infantil", 1999));
        listaLibros.add(new LibroDTO(4, "Coraline", "Neil Gaiman", "Fantasía", 2002));
        listaLibros.add(new LibroDTO(5, "Las Crónicas de Narnia", "C. S. Lewis", "Aventura", 1950));
        listaLibros.add(new LibroDTO(6, "Peter Pan", "J. M. Barrie", "Clásico", 1911));

        List<LibroDTO> resultados = new ArrayList<>();

        for (LibroDTO libro : listaLibros) {

            if (libro.getGenero().equalsIgnoreCase(genero)) {
                resultados.add(libro);
            }

        }

        model.addAttribute("genero", genero);
        model.addAttribute("libros", resultados);

        return "buscar-libro";
    }

    @GetMapping("/detalle/{id}")
    public String mostrarDetalle(@PathVariable Integer id, Model model) {

        List<LibroDTO> listaLibros = new ArrayList<>();

        listaLibros.add(new LibroDTO(1, "El Principito", "Antoine de Saint-Exupéry", "Infantil", 1943));
        listaLibros.add(new LibroDTO(2, "Matilda", "Roald Dahl", "Infantil", 1988));
        listaLibros.add(new LibroDTO(3, "El Grúfalo", "Julia Donaldson", "Infantil", 1999));
        listaLibros.add(new LibroDTO(4, "Coraline", "Neil Gaiman", "Fantasía", 2002));
        listaLibros.add(new LibroDTO(5, "Las Crónicas de Narnia", "C. S. Lewis", "Aventura", 1950));
        listaLibros.add(new LibroDTO(6, "Peter Pan", "J. M. Barrie", "Clásico", 1911));

        LibroDTO libroEncontrado = null;

        for (LibroDTO libro : listaLibros) {

            if (libro.getId().equals(id)) {
                libroEncontrado = libro;
                break;
            }

        }

        model.addAttribute("libro", libroEncontrado);

        return "detalle-libro";
    }

    @GetMapping("/biblioteca")
    public String mostrarBiblioteca(Model model) {

        model.addAttribute("nombreBiblioteca", nombreBiblioteca);

        return "biblioteca";
    }

}
