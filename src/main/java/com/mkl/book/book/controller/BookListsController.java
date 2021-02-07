package com.mkl.book.book.controller;

import com.mkl.book.book.domain.Book;
import com.mkl.book.book.service.BookDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@RequestMapping("/book")
@Controller
public class BookListsController {

    private final BookDBService bookDBService;

    @Autowired
    public BookListsController(BookDBService bookDBService) {
        this.bookDBService = bookDBService;
    }

    @GetMapping("/list")
    public String GoBookList(Model model){

        List<Book> bookList = bookDBService.initFindBooksBypageRequest().getContent();

        model.addAttribute("bookList", bookList);
        return "booklist";
    }

    @GetMapping("/list/getBookList")
    @ResponseBody
    public Page<Book> getBookList(@PageableDefault(size = 3) Pageable pageable){
        Page<Book> books = bookDBService.findBooksBypageRequest(pageable);
        return books;
    }

    @RequestMapping("/list/detail")
    public String GoBookDetail() {
        return "bookdetail";
    }
}
