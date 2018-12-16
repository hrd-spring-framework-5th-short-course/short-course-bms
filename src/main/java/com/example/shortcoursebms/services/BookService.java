package com.example.shortcoursebms.services;

import com.example.shortcoursebms.models.Book;
import com.example.shortcoursebms.models.responses.BookResponse;

import java.util.List;

public interface BookService {

    List<Book> getAllBook();

    List<BookResponse> getAllBookResponse();
}
