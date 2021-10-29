package com.example.books.repos;

import com.example.books.models.entityModels.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Long> {
}
