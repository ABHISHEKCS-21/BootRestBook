package com.mypack.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Book_ID")
	private  int bookId;
	private String BookName;
	private String AutherName;
	private Double BookPrise;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int bookId, String bookName, String autherName, Double bookPrise) {
		super();
		this.bookId = bookId;
		BookName = bookName;
		AutherName = autherName;
		BookPrise = bookPrise;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getAutherName() {
		return AutherName;
	}
	public void setAutherName(String autherName) {
		AutherName = autherName;
	}
	public Double getBookPrise() {
		return BookPrise;
	}
	public void setBookPrise(Double bookPrise) {
		BookPrise = bookPrise;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", BookName=" + BookName + ", AutherName=" + AutherName + ", BookPrise="
				+ BookPrise + "]";
	}
	
	

}
