package com.school.book.service;

import com.school.book.entity.Book;

public interface BookService  {

	Object queryAll(Book book);

	Object add(Book book);

	Object update(Book book);


}