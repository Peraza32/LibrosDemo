package org.peraza.librosdemo.repositories;

import org.peraza.librosdemo.models.entity.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Integer> {
    List<Genre> findAll();
    Optional<Genre> getGenreByName(String name);
    Genre  getGenreById(Integer id);
}
