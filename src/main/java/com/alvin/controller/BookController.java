package com.alvin.controller;

import com.alvin.pojo.Books;
import com.alvin.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    /**
     * 查询全部书籍，并且返回一个书籍展示页面
     * @param model
     * @return
     */
    @RequestMapping("/allBook")
    public String list(Model model)
    {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }


    @RequestMapping("/toAddBook")
    public String toAddPage()
    {
        return "addBook";
    }

    @RequestMapping("/toUpdatePage")
    public String toUpdatePage(int id, Model model)
    {
        Books book = bookService.queryBookById(id);
        model.addAttribute("book",book);
        return "updatePage";
    }


    @RequestMapping("/addBook")
    public String addBook(Books book)
    {
        System.out.println("addBook : " + book);
        bookService.addBook(book);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Books book)
    {
        System.out.println("updateBook : " + book);
        bookService.updateBook(book);
        return "redirect:/book/allBook";
    }

    /*
    *  使用RESTful风格的 url
    * */
    @RequestMapping("/delBook/{bookID}")
    public String delBook(@PathVariable("bookID") int id)
    {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }


    @RequestMapping("/queryBook")
    public String queryBook( String queryBookName, Model model)
    {
        List<Books> books = bookService.queryBookByName(queryBookName);
        if(books.size() == 0)
        {
            books = bookService.queryAllBook();
            model.addAttribute("error", "未查到");
        }

        model.addAttribute("list", books);
        return "allBook";
    }
}

/*
* @Autowired是根据类型进行自动装配的。
* 如果当spring上下文中存在不止一个UserDao类型的bean时，
* 就会抛出BeanCreationException异常;
* 如果Spring上下文中不存在UserDao类型的bean，也会抛出BeanCreationException异常。
*
* 我们可以使用@Qualifier配合@Autowired来解决这些问题。
* */

/*
* @RequestMapping("/allBook")
* 若不配置method，则任何请求都可匹配
* */