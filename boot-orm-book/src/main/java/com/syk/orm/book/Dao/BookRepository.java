package com.syk.orm.book.Dao;


import com.syk.orm.book.enilty.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author 沈永康
 * @Date 2022/3/19 10:30
 * @Version 1.0
 */


public interface BookRepository  extends JpaRepository<Book,Integer> , JpaSpecificationExecutor<Book> {
}
