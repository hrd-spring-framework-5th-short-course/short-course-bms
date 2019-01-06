package com.example.shortcoursebms.services.impl;

import com.example.shortcoursebms.models.Author;
import com.example.shortcoursebms.repositories.AuthorRepository;
import com.example.shortcoursebms.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAll() {
        return this.authorRepository.getAll();
    }
}
