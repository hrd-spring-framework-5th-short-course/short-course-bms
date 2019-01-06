package com.example.shortcoursebms.controllers.restcontrollers;

import com.example.shortcoursebms.models.Book;
import com.example.shortcoursebms.models.forms.BookForm;
import com.example.shortcoursebms.models.responses.BookResponse;
import com.example.shortcoursebms.services.BookService;
import com.example.shortcoursebms.utilities.Paginate;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/books")
public class BookRestController {

    private BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("")
    public ResponseEntity<Map<String, Object>> save(@RequestBody BookForm bookForm) {

        Map<String, Object> response = new HashMap<>();

        System.out.println(bookForm);

        Boolean status = this.bookService.save(bookForm);

        if (status) {

            this.bookService.saveBookAuthor(bookForm);

            response.put("status", true);
            response.put("message", "Save Books Successfully!!!");

            return new ResponseEntity<>(response, HttpStatus.OK);

        }
        else {
            response.put("status", false);
            response.put("message", "Save Books Failed!!!");
            response.put("version", "V1");

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        }
    }


    @GetMapping("")
    public ResponseEntity<Map<String, Object>> getAllBook(Paginate paginate) {

        Map<String, Object> response = new HashMap<>();

        List<Book> books = this.bookService.getAllBook(paginate);
        int totalRecord = this.bookService.count();

        if (books.size() > 0) {

            paginate.setTotalCount(totalRecord);

            response.put("status", true);
            response.put("message", "Get Books Successfully!!!");
            response.put("data", books);
            response.put("paging", paginate);

            return new ResponseEntity<>(response, HttpStatus.OK);

        }
        else {

            response.put("status", false);
            response.put("message", "Get Books Not Found!!!");
            response.put("data", books);
            response.put("version", "V1");

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        }
    }


    @GetMapping("/response")
    public ResponseEntity<Map<String, Object>> getAllBookResponseInRest() {

        Map<String, Object> response = new HashMap<>();

        List<BookResponse> bookResponses = this.bookService.getAllBookResponse();

        if (bookResponses.size() > 0) {

            response.put("status", true);
            response.put("message", "Get Books Response Successfully!!!");
            response.put("data", bookResponses);

            return new ResponseEntity<>(response, HttpStatus.OK);

        }
        else {

            response.put("status", false);
            response.put("message", "Get Books Response Not Found!!!");
            response.put("data", bookResponses);

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        }
    }




}
