package com.example.graphQL.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.graphQL.model.Book;
import com.example.graphQL.repository.BookRepo;

@Service
public class BookServiceImpl implements BookService {
	private BookRepo bookRepo;

	@Autowired
	public BookServiceImpl(BookRepo bookRepo) {

		this.bookRepo = bookRepo;
	}

	@Override
	public Book create(Book book) {
		// TODO Auto-generated method stub
		return this.bookRepo.save(book);
	}

	@Override
	public List<Book> getAll() {
		// TODO Auto-generated method stub
		return this.bookRepo.findAll();
	}

	@Override
	public Book get(int bookId) {
		// TODO Auto-generated method stub
		return this.bookRepo.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found on Server"));
	}

	@Override
	public boolean deleteBook(int bookId) {
		// TODO Auto-generated method stub
		bookRepo.deleteById(bookId);
		return true;
		
	}

	@Override
	public Book update(Book bookToUpdate) {
		// TODO Auto-generated method stub
		return this.bookRepo.save(bookToUpdate);
	}

}
