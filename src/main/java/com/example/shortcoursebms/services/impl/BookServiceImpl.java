package com.example.shortcoursebms.services.impl;

import com.example.shortcoursebms.models.Book;
import com.example.shortcoursebms.models.responses.BookResponse;
import com.example.shortcoursebms.repositories.BookRepository;
import com.example.shortcoursebms.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBook() {

        return this.bookRepository.getAllBook();
    }

    @Override
    public List<BookResponse> getAllBookResponse() {
        return this.bookRepository.getAllBookResponse();
    }
}
