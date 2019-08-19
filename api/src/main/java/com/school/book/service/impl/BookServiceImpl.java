package com.school.book.service.impl;

import com.school.book.util.ModelDao;
import com.school.book.entity.Book;
import com.school.book.dao.BookDao;
import com.school.book.service.BookService;

import java.util.List;
import java.util.Date;

import com.school.book.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
    BookDao bookDao;

	@Override
	public Object queryAll(Book book){
		List<Book> list = bookDao.query(book);
		return  list;
	}

	@Override
	public Object add(Book book){
		book.setInputTime(StringUtil.getCurrentTimeToString());
		bookDao.insert(book);
		return  "100";
	}

	@Override
	public Object update(Book book){
		bookDao.updateById(book);
		return "100";
	}

}