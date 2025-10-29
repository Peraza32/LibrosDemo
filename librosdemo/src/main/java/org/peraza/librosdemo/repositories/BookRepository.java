package org.peraza.librosdemo.repositories;

import org.peraza.librosdemo.models.entity.Book;
import org.peraza.librosdemo.models.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
    Optional<Book> getBookById(UUID id);
    Optional<Book> getBookByName(String name);
    Book save(Book book);
    List<Book> getBooksByGenre(Genre genre);
    List<Book> findAll();
}
