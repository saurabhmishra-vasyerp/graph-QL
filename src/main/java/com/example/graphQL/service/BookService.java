package com.example.graphQL.service;

import java.util.List;

import com.example.graphQL.model.Book;

public interface BookService {
	Book create(Book book);

	List<Book> getAll();

	Book get(int bookId);

	boolean deleteBook(int bookId);

	Book update(Book bookToUpdate);

}
