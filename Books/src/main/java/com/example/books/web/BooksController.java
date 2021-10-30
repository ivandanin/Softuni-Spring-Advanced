package com.example.books.web;

import com.example.books.models.dtos.BookDTO;
import com.example.books.services.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping()
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> books = booksService.getAllBooks();

        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable("id") Long id) {
          Optional<BookDTO> bookDTO = booksService.getBookById(id);
          if (bookDTO.isEmpty()) {
              return ResponseEntity.notFound().build();
          } else {
              return ResponseEntity.ok(bookDTO.get());
          }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookDTO> deleteBook(@PathVariable("id") Long id) {
        booksService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> update(@PathVariable("id") Long bookId,
                                          @RequestBody BookDTO bookDTO) {
        Long updateBookId = booksService.updateBook(bookDTO.setId(bookId));
        return updateBookId != null ?
                ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO,
                                              UriComponentsBuilder builder) {
        Long bookId = booksService.createBook(bookDTO);
        URI location = builder.path("/books/{id}")
                .buildAndExpand(bookId)
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
