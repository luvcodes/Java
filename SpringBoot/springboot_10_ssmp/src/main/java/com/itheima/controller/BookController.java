package com.itheima.controller;

import com.itheima.controller.utils.R;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;


    @PostMapping
    public R save(@RequestBody Book book) {
        R r = new R(bookService.save(book));
        return r;
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        return new R(bookService.modify(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(bookService.delete(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        // 这样写就是不管是不是空，都是查询成功
        return new R(true, bookService.getById(id));
    }

    @GetMapping
    public R getAll() {
        return new R(true, bookService.list());
    }


    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        return new R(true, bookService.getPage(currentPage, pageSize));
    }
}
