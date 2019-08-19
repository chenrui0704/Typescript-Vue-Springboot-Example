package com.school.book.dao;
import com.school.book.entity.Book;
import com.school.book.util.ModelDao;


public  interface BookDao extends ModelDao<Book> {

    void delete(Book book);


}
