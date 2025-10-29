package org.peraza.librosdemo.services;

import org.peraza.librosdemo.models.entity.Genre;
import org.peraza.librosdemo.repositories.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    private GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Optional<Genre> getGenreByName(String genreName) {
        return genreRepository.getGenreByName(genreName);
    }

}
