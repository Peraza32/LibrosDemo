package org.peraza.librosdemo.services;

import org.peraza.librosdemo.models.entity.Book;
import org.peraza.librosdemo.models.entity.Genre;
import org.peraza.librosdemo.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(UUID id) {
        return bookRepository.getBookById(id);
    }

    public Optional<Book> getBookByName(String name) {
        return bookRepository.getBookByName(name);
    }

    public List<Book> getBookByGenre(Genre genre) {
        return bookRepository.getBooksByGenre(genre);
    }

    public Book update(Book book) {
        return bookRepository.save(book);
    }
}
