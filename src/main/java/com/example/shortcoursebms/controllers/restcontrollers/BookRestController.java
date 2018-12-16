package com.example.shortcoursebms.controllers.restcontrollers;

import com.example.shortcoursebms.models.Book;
import com.example.shortcoursebms.models.responses.BookResponse;
import com.example.shortcoursebms.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @GetMapping("")
    public ResponseEntity<Map<String, Object>> getAllBook() {

        Map<String, Object> response = new HashMap<>();

        List<Book> books = this.bookService.getAllBook();

        if (books.size() > 0) {

            response.put("status", true);
            response.put("message", "Get Books Successfully!!!");
            response.put("data", books);

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
