package com.example.books.services.impl;

import com.example.books.models.dtos.AuthorDTO;
import com.example.books.models.dtos.BookDTO;
import com.example.books.models.entityModels.Author;
import com.example.books.models.entityModels.BookEntity;
import com.example.books.repos.AuthorRepo;
import com.example.books.repos.BookRepo;
import com.example.books.services.BooksService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BooksServiceImpl implements BooksService {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final ModelMapper modelMapper;

    public BooksServiceImpl(AuthorRepo authorRepo, BookRepo bookRepo, ModelMapper modelMapper) {
        this.authorRepo = authorRepo;
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

    @Override
    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }

    @Override
    public Long createBook(BookDTO bookDTO) {
        Author author = authorRepo
                .findByName(bookDTO.getAuthor().getName())
                .orElseGet(() -> new Author().setName(bookDTO.getAuthor().getName()));

        this.authorRepo.save(author);

        BookEntity newBook = new BookEntity()
                .setAuthor(author)
                .setIsbn(bookDTO.getIsbn())
                .setTitle(bookDTO.getTitle());

        return bookRepo.save(newBook).getId();
    }

    @Override
    public Long updateBook(BookDTO bookDTO) {
        BookEntity bookEntity = bookRepo.findById(bookDTO.getId())
                .orElse(null);
        if (bookEntity == null) {
            return null;
        }

        Author author = authorRepo.findByName(bookDTO.getAuthor().getName())
                .orElseGet(() -> {
                    Author newAuthor = new Author().setName(bookDTO.getAuthor().getName());
                    return authorRepo.save(newAuthor);
                });

        bookEntity.setTitle(bookDTO.getTitle())
                .setIsbn(bookDTO.getIsbn())
                .setAuthor(author);

        return bookRepo.save(bookEntity).getId();
    }
}
