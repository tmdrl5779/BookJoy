package com.mkl.book.book.service;

import com.mkl.book.book.domain.Book;
import com.mkl.book.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BookDBService {
    private final BookRepository bookRepository;

    @Autowired
    public BookDBService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Page<Book> initFindBooksBypageRequest(){
        PageRequest pageRequest = PageRequest.of(0,3);
        return bookRepository.findAll(pageRequest);
    }

    public Page<Book> findBooksBypageRequest(Pageable pageable){
        return bookRepository.findAll(pageable);
    }

}
