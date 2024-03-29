package com.alvin.service;

import com.alvin.dao.BookMapper;
import com.alvin.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService{

    /*
        Service 调用 Dao 层
    * */
    private BookMapper bookMapper;
    public void setBookMapper(BookMapper bookMapper)
    {
        this.bookMapper = bookMapper;
    }

    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    @Override
    public List<Books> queryBookByName(String name)  {
        return bookMapper.queryBookByName(name);
    }
}
