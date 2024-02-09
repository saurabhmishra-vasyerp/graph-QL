package com.example.graphQL.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import lombok.Getter;
//import lombok.Setter;

@Entity
@Table(name = "graph_book")
//@Getter
//@Setter
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String descd;
	private String author;
	private double price;
	private int pages;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return descd;
	}

	public void setDesc(String desc) {
		this.descd = desc;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
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
		return "Book [id=" + id + ", title=" + title + ", desc=" + descd + ", author=" + author + ", price=" + price
				+ ", pages=" + pages + "]";
	}

}
