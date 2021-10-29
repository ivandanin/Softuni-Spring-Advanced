package com.example.books.services.impl;

import com.example.books.models.dtos.AuthorDTO;
import com.example.books.models.dtos.BookDTO;
import com.example.books.models.entityModels.BookEntity;
import com.example.books.repos.BookRepo;
import com.example.books.services.BooksService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BooksServiceImpl implements BooksService {

    private final BookRepo bookRepo;
    private final ModelMapper modelMapper;

    public BooksServiceImpl(BookRepo bookRepo, ModelMapper modelMapper) {
        this.bookRepo = bookRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        bookRepo.findAll().stream()
                .map(this::asBook)
                .collect(Collectors.toList());
        return null;
    }

    private BookDTO asBook(BookEntity bookEntity) {
        BookDTO bookDTO = modelMapper.map(bookEntity, BookDTO.class);
        AuthorDTO authorDTO = modelMapper.map(bookEntity.getAuthor(), AuthorDTO.class);
        bookDTO.setAuthor(authorDTO);
        return bookDTO;
    }

    @Override
    public Optional<BookDTO> getBookById(Long id) {
        return bookRepo.findById(id).map(this::asBook);
    }
}
