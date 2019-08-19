package com.school.book.controller;

import com.school.book.entity.Book;
import com.school.book.service.BookService;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController  {

	@Autowired
    BookService bookService;

	@RequestMapping("/queryAll")
	public Object queryAll(@RequestBody Book book){
		return  bookService.queryAll(book);
	}

	@RequestMapping("/add")
	public Object add(@RequestBody Book book){
		return  bookService.add(book);
	}

	@RequestMapping("/update")
	public Object update(@RequestBody Book book){
		return  bookService.update(book);
	}

}