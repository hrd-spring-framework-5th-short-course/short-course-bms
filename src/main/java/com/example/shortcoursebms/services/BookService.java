package com.example.shortcoursebms.services;

import com.example.shortcoursebms.models.Book;
import com.example.shortcoursebms.models.forms.BookForm;
import com.example.shortcoursebms.models.responses.BookResponse;
import com.example.shortcoursebms.utilities.Paginate;

import java.util.List;

public interface BookService {

    List<Book> getAllBook(Paginate paginate);

    int count();

    List<BookResponse> getAllBookResponse();

    boolean save(BookForm bookForm);
    boolean saveBookAuthor(BookForm bookForm);
}
