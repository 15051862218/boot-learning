package com.syk.orm.book.service;


import com.syk.orm.book.enilty.Book;
import org.springframework.data.domain.Page;

/**
 * @Author 沈永康
 * @Date 2022/3/19 10:31
 * @Version 1.0
 */


public interface BookService {
    Page<Book> findBookNoCriteria(Integer page,Integer size);


    Page<Book> findBookCriteria(Integer page,Integer size,Book book);
}
