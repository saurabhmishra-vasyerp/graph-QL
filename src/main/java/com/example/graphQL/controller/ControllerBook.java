package com.example.graphQL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.example.graphQL.model.Book;
import com.example.graphQL.service.BookService;

@Controller
//@RestController
//@RequestMapping("/books")
public class ControllerBook {
	@Autowired
	private BookService bookService;

	// @PostMapping
	@MutationMapping("createBook")
	public Book create(@Argument BookInput book) {
		Book b = new Book();
		b.setAuthor(book.getAuthor());
		b.setDesc(book.getDescd());
		b.setPages(book.getPages());
		b.setPrice(book.getPrice());
		b.setTitle(book.getTitle());
		return this.bookService.create(b);

	}

	// @GetMapping
	@QueryMapping("allBooks")
	public List<Book> getAll() {
		return this.bookService.getAll();
	}

	// @GetMapping("/{bookId}")
	@QueryMapping("getBook")
	public Book get(@Argument int bookId) {
		return this.bookService.get(bookId);
	}
	
	@MutationMapping("deleteBook")
    public boolean deleteBook(@Argument int bookId) {
        return bookService.deleteBook(bookId);
    }
	@MutationMapping(name = "updateBook")
    public Book updateBook(@Argument("bookId") int bookId, @Argument("book") BookInput bookInput) {
        Book bookToUpdate = bookService.get(bookId);
        if (bookToUpdate != null) {
            bookToUpdate.setTitle(bookInput.getTitle());
            bookToUpdate.setAuthor(bookInput.getAuthor());
            bookToUpdate.setDesc(bookInput.getDescd());
            bookToUpdate.setPages(bookInput.getPages());
            bookToUpdate.setPrice(bookInput.getPrice());
            return bookService.update(bookToUpdate);
        } else {
            throw new RuntimeException("Book with ID " + bookId + " not found.");
        }
    }

}

class BookInput {
	
	private String title;
	private String descd;
	private String author;
	private double price;
	private int pages;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescd() {
		return descd;
	}

	public void setDescd(String descd) {
		this.descd = descd;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice(){
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "BookInput [title=" + title + ", descd=" + descd + ", author=" + author + ", price=" + price + ", pages="
				+ pages + "]";
	}

}