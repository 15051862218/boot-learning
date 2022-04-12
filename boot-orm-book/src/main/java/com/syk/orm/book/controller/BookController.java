package com.syk.orm.book.controller;


import com.syk.orm.book.enilty.Book;
import com.syk.orm.book.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author 沈永康
 * @Date 2022/3/19 10:54
 * @Version 1.0
 */

@RestController
@RequestMapping(value = "/api/Book")
public class BookController {
    @Resource
    BookService bookService;
    @GetMapping("/BookNoQuery")
    public Page<Book> findBookNoCriteria(@RequestParam Integer page, @RequestParam Integer size){
        return bookService.findBookNoCriteria(page,size);
    }
    @GetMapping("/BookQuery")
    public Page<Book> findBookCriteria(
            @RequestParam Integer page,
            @RequestParam Integer size,
            Integer id,
            String cover,
            String name
    ){
        Book book = Book.builder()
                .id(id)
                .cover(cover)
                .name(name)
                .build();
        return bookService.findBookCriteria(page,size,book);
    }
}

