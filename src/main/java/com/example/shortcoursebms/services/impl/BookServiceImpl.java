package com.example.shortcoursebms.services.impl;

import com.example.shortcoursebms.models.Book;
import com.example.shortcoursebms.models.forms.BookForm;
import com.example.shortcoursebms.models.responses.BookResponse;
import com.example.shortcoursebms.repositories.BookRepository;
import com.example.shortcoursebms.services.BookService;
import com.example.shortcoursebms.utilities.Paginate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public boolean save(BookForm bookForm) {
        return this.bookRepository.save(bookForm);
    }

    @Override
    public boolean saveBookAuthor(BookForm bookForm) {
        return this.bookRepository.saveBookAuthor(bookForm);
    }

    @Override
    public int count() {
        return this.bookRepository.count();
    }

    @Override
    public List<Book> getAllBook(Paginate paginate) {

        return this.bookRepository.getAllBook(paginate);
    }

    @Override
    public List<BookResponse> getAllBookResponse() {
        return this.bookRepository.getAllBookResponse();
    }
}
