package com.mypack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mypack.entities.Book;
import com.mypack.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;

	// Add Book Controller..........................
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book bok=null;
		try {
			bok=bookService.addBook(book);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}

	// Get All Book Controller........................
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBook() {
		List<Book> list = bookService.getAllBooks();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	// Get Book by Id.................................
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> GetBookById(@PathVariable("id") int id) {
		Book book1=this.bookService.BookById(id);
		if(book1==null) 
		{
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book1));
	}

	// Delete Book by Id................................
	@DeleteMapping("books/{id}")
	public ResponseEntity<Book> Delete(@PathVariable("id") int id) {
		try {
			this.bookService.DeleteBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
		} catch (Exception e) {

			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}

	// Update Book Using id.............................
	@PutMapping("books/{bid}")
	public ResponseEntity<Book> Update(@RequestBody Book bk, @PathVariable("bid") int bid) {
		try {
			 
					this.bookService.UpdateBook(bk, bid);
					return ResponseEntity.ok().body(bk);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
