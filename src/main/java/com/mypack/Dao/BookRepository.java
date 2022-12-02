package com.mypack.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.mypack.entities.Book;
@Component
public interface BookRepository extends CrudRepository<Book, Integer> {
//public Book findByid(int bookId);
}
