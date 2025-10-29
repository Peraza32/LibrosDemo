package org.peraza.librosdemo.repositories;

import org.peraza.librosdemo.models.entity.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GenreRepository extends CrudRepository<Genre, Integer> {
    List<Genre> getAllGenres();
    Genre  getGenreByName(String name);
    Genre  getGenreById(Integer id);
}
