package org.peraza.librosdemo.controllers;

import org.peraza.librosdemo.models.dtos.BookDTO;
import org.peraza.librosdemo.models.dtos.BooknGenreDTO;
import org.peraza.librosdemo.models.dtos.GenreDTO;
import org.peraza.librosdemo.models.entity.Book;
import org.peraza.librosdemo.models.entity.Genre;
import org.peraza.librosdemo.services.BookService;
import org.peraza.librosdemo.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private GenreService genreService;

    @GetMapping("/genre")
    ResponseEntity<List<BooknGenreDTO>> getBooksByGenre(GenreDTO genreDTO) {
        if (genreDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<Genre> genre = genreService.getGenreByName(genreDTO.getGenre());
        if (genre.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Book> books  =bookService.getBookByGenre(genre.get());
        List<BooknGenreDTO> result = books.stream()
                .map(book -> new BooknGenreDTO(
                        book.getName(),
                        book.getSummary(),
                        book.getPrice(),
                        book.getState(),
                        book.getImg(),
                        genre.get().getName()
                )).toList();

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    ResponseEntity<BookDTO> getBookById(@PathVariable UUID id){
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<Book> book = bookService.findById(id);
        if (book.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BookDTO bookDTO = new BookDTO(
                book.get().getName(),
                book.get().getSummary(),
                book.get().getPrice(),
                book.get().getState(),
                book.get().getImg()
                );

        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    ResponseEntity<BookDTO> updateBook(@PathVariable UUID id, @RequestBody BookDTO bookDTO){
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<Book> existingBook = bookService.findById(id);
        if (existingBook.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Book book = existingBook.get();
        if (bookDTO.getTitle() != null)
            book.setName(bookDTO.getTitle());
        if (bookDTO.getSummary() != null)
            book.setSummary(bookDTO.getSummary());
        if (bookDTO.getPrice() != null)
            book.setPrice(bookDTO.getPrice());
        if (bookDTO.getState() != null)
            book.setState(bookDTO.getState());
        if (bookDTO.getImage() != null)
            book.setImg(bookDTO.getImage());

        bookService.update(book);
        BookDTO updatedBookDTO = new BookDTO(
                book.getName(),
                book.getSummary(),
                book.getPrice(),
                book.getState(),
                book.getImg()
        );
        return new ResponseEntity<>(updatedBookDTO, HttpStatus.OK);
    }
}
