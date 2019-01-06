package com.example.shortcoursebms.controllers.restcontrollers;

import com.example.shortcoursebms.models.Author;
import com.example.shortcoursebms.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorRestController {

    private AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("")
    public ResponseEntity<Map<String, Object>> getAllAuthors() {

        Map<String, Object> response = new HashMap<>();

        List<Author> authors = this.authorService.getAll();

        if (!authors.isEmpty()) {
            response.put("data", authors);
            response.put("message", "Get all success!");
            response.put("status", true);

            return ResponseEntity.ok(response);

        } else {
            response.put("message", "Get all failed!");
            response.put("status", false);

            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }



    }


}
