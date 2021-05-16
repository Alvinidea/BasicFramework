package com.alvin.dao;

import com.alvin.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * XXXMapper.java 文件与 XXXMapper.xml 文件一一对应
 *
 * @Param 是 MyBatis（org.apache.ibatis.annotations.Param）
 * 所提供的Dao层的注解，作用是传递参数，从而与SQL中的字段名对应
 * */
public interface BookMapper {
    // add a book
    int addBook(Books books);

    // del a book
    int deleteBookById(@Param("bookID") int id);

    // upd a book
    int updateBook(Books books);

    // sel a book
    Books queryBookById(@Param("bookID") int id);

    // sel all books
    List<Books> queryAllBook();


    List<Books> queryBookByName(@Param("bookName") String bookName);
}
