package com.example.books.web;

import com.example.books.models.dtos.BookDTO;
import com.example.books.services.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> books = booksService.getAllBooks();

        return ResponseEntity.ok(books);
    }

    @GetMapping("/id")
    public ResponseEntity<BookDTO> getBookById(@PathVariable("id") Long id) {
          Optional<BookDTO> bookDTO = booksService.getBookById(id);
          if (bookDTO.isEmpty()) {
              return ResponseEntity.notFound().build();
          } else {
              return ResponseEntity.ok(bookDTO.get());
          }
    }
}
