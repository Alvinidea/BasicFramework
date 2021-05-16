package com.alvin.service;

import com.alvin.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {

    // add a book
    int addBook(Books books);

    // del a book
    int deleteBookById( int id);

    // upd a book
    int updateBook(Books books);

    // sel a book
    Books queryBookById( int id);

    // sel all books
    List<Books> queryAllBook();

    // sel a books
    List<Books> queryBookByName( String name) ;
}
