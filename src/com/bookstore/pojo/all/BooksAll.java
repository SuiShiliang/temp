package com.bookstore.pojo.all;

import com.bookstore.pojo.Authors;
import com.bookstore.pojo.Book_authors;
import com.bookstore.pojo.Book_batchs;
import com.bookstore.pojo.Book_chapters;
import com.bookstore.pojo.Book_discounts;
import com.bookstore.pojo.Book_images;
import com.bookstore.pojo.Books;
import com.bookstore.pojo.ImagesM;

public class BooksAll {

	private Books books;
	private Book_images book_images;
	private Book_batchs batchs;
	private Book_discounts discounts;
	private Book_authors book_authors;
	private Book_chapters chapters;
	private Authors authors;
	private ImagesM imagesM;
	public Books getBooks() {
		return books;
	}
	public void setBooks(Books books) {
		this.books = books;
	}
	public Book_images getBook_images() {
		return book_images;
	}
	public void setBook_images(Book_images book_images) {
		this.book_images = book_images;
	}
	public Book_batchs getBatchs() {
		return batchs;
	}
	public void setBatchs(Book_batchs batchs) {
		this.batchs = batchs;
	}
	public Book_discounts getDiscounts() {
		return discounts;
	}
	public void setDiscounts(Book_discounts discounts) {
		this.discounts = discounts;
	}
	public Book_authors getBook_authors() {
		return book_authors;
	}
	public void setBook_authors(Book_authors book_authors) {
		this.book_authors = book_authors;
	}
	public Book_chapters getChapters() {
		return chapters;
	}
	public void setChapters(Book_chapters chapters) {
		this.chapters = chapters;
	}
	public Authors getAuthors() {
		return authors;
	}
	public void setAuthors(Authors authors) {
		this.authors = authors;
	}
	public ImagesM getImagesM() {
		return imagesM;
	}
	public void setImagesM(ImagesM imagesM) {
		this.imagesM = imagesM;
	}
	@Override
	public String toString() {
		return "BooksAll [books=" + books + ", book_images=" + book_images + ", batchs=" + batchs + ", discounts="
				+ discounts + ", book_authors=" + book_authors + ", chapters=" + chapters + ", authors=" + authors
				+ ", imagesM=" + imagesM + "]";
	}
	
}
