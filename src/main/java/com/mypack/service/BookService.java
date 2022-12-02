package com.mypack.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypack.Dao.BookRepository;
import com.mypack.entities.Book;

@Service
public class BookService {
	@Autowired
	 private BookRepository bookRepository;

	/*
	 * private static List<Book> list = new ArrayList(); static {
	 * 
	 * list.add(new Book(12, "Java Complite Referance", "QWERT", 150.55));
	 * list.add(new Book(13, "Java Realtime Project", "POIUY", 160.50));
	 * list.add(new Book(14, "Java Programming ", "ZXCV", 165.25)); list.add(new
	 * Book(15, "Java SpringBoot", "LKJH", 125.75)); }
	 */

	// Adding New Book.....................
	public Book addBook(Book b) {
	Book result=	this.bookRepository.save(b);
		//list.add(b);
		return result;
	}

	// Get All Books........................
	public List<Book> getAllBooks() {
		List list = (List)bookRepository.findAll();
		return list;
	}

	// Get Single Book by Id..................
	public Book BookById(int id) {
		Book b = null;
		//b= this.bookRepository.findByid(id);
		/*
		 * try { b = list.stream().filter(e -> e.getBookId() == id).findFirst().get();
		 * }catch(Exception e) { e.printStackTrace(); }
		 */
		
		return b;
	}

	// Deleting Book by Id....................
	public void DeleteBook(int id) {
		/*
		 * list=list.stream().filter(b-> { if(b.getBookId()!=id) { return true; }else {
		 * return false; }
		 * 
		 * }).collect(Collectors.toList());
		 */
//list = list.stream().filter(book ->book.getBookId()!=id).collect(Collectors.toList());
                   bookRepository.deleteById(id);
	}

	public Book UpdateBook( Book bk,int bid) {
		/*
		 * list=list.stream().map(e ->{ if(e.getBookId()==bid) {
		 * e.setBookName(bk.getBookName()); e.setAutherName(bk.getAutherName());
		 * e.setBookPrise(bk.getBookPrise()); } return e;
		 * }).collect(Collectors.toList()); return null;
		 */
		bk.setBookId(bid);
		Book book = bookRepository.save(bk);
		return book;
	}
}
