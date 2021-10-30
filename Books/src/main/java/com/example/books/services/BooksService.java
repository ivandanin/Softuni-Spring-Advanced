package com.example.books.services;


import com.example.books.models.dtos.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BooksService {

    List<BookDTO> getAllBooks();

    Optional<BookDTO> getBookById(Long id);

    void deleteBook(Long id);

    Long createBook(BookDTO bookDTO);

    Long updateBook(BookDTO bookDTO);
}
