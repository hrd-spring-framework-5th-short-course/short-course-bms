package com.example.shortcoursebms.controllers;

import com.example.shortcoursebms.models.Book;
import com.example.shortcoursebms.models.forms.BookForm;
import com.example.shortcoursebms.services.AuthorService;
import com.example.shortcoursebms.services.BookService;
import com.example.shortcoursebms.services.CategoryService;
import com.example.shortcoursebms.services.impl.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/add")
    public String showAddBookForm(Model model) {

        model.addAttribute("bookForm", new BookForm());
        model.addAttribute("authors", this.authorService.getAll());
        model.addAttribute("categories", this.categoryService.getAllCategory(""));
//
        return "admin/books/add-book";
    }

    @GetMapping("/add-ajax")
    public String showAddBookFormAjax() {
        return "admin/books/add-book-ajax";
    }

    @GetMapping("/all")
    public String showAllBookForm() {
        return "admin/books/all-book";
    }

    @PostMapping("/add/submit")
    public String save(BookForm bookForm,@RequestParam("cover") MultipartFile file) {

        System.out.println(file);

        String filename = this.fileUploadService.upload(file);

        bookForm.setBookImage(filename);

        System.out.println(bookForm);

        if (this.bookService.save(bookForm)) {

            this.bookService.saveBookAuthor(bookForm);
        }

        return "redirect:/admin/books/add";
    }


    @PostMapping("/update/submit")
    public String update(BookForm bookForm, @RequestParam("cover") MultipartFile file) {
        System.out.println(file);

        String filename = this.fileUploadService.upload(file);

        bookForm.setBookImage(filename);
        System.out.println(bookForm);

        if (this.bookService.update(bookForm)) {

            Book book = this.bookService.getOneBook(bookForm.getId());

            this.bookService.deleteBookAuthor(bookForm.getId());

            this.bookService.saveBookAuthor(bookForm);


        }

        return "redirect:/admin/books/all";
    }


    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {

        Book book = this.bookService.getOneBook(id);

        System.out.println(book);

        if (book != null) {
            model.addAttribute("bookForm", book);
            model.addAttribute("authors", this.authorService.getAll());
            model.addAttribute("categories", this.categoryService.getAllCategory(""));
            return "admin/books/update-book";
        }
        return "redirect:/admin/books/all";

    }








}
