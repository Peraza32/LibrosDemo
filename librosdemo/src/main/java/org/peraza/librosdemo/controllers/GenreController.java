package org.peraza.librosdemo.controllers;

import org.peraza.librosdemo.models.dtos.GenreDTO;
import org.peraza.librosdemo.models.entity.Genre;
import org.peraza.librosdemo.repositories.GenreRepository;
import org.peraza.librosdemo.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    private GenreService genreService;


    @GetMapping("/all")
    ResponseEntity<List<GenreDTO>> getGenres() {
        List<Genre> genres = genreService.getAllGenres();
        List<GenreDTO> result = genres.stream()
                .map(g -> new GenreDTO(g.getName()) )
                .toList();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
