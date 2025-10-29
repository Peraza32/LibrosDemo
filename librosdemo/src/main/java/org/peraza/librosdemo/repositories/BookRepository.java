package org.peraza.librosdemo.repositories;

import org.peraza.librosdemo.models.entity.Book;
import org.peraza.librosdemo.models.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
    Book getBookById(UUID id);
    Book getBookByName(String name);
    Book updateBook(Book book);
    Book createBook(Book book);
    List<Book> getBooksByGenre(Genre genre);
}
