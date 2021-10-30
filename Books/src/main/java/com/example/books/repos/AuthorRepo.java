package com.example.books.repos;

import com.example.books.models.entityModels.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
    Optional<Author> findByName(String name);
}
