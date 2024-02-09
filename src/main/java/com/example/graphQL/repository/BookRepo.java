package com.example.graphQL.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.graphQL.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
