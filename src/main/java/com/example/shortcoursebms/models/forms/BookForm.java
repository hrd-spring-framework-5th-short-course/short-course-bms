package com.example.shortcoursebms.models.forms;

import com.example.shortcoursebms.models.Author;
import com.example.shortcoursebms.models.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookForm {

    private Integer id;

    private String title;

    private String ISBN;


    private String bookImage;

    private List<Integer> authors = new ArrayList<>();

    private Category category;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;

    private boolean status;

    private Timestamp createdAt;

    public BookForm() {
    }

    public BookForm(Integer id, String title, String ISBN, String bookImage, List<Integer> authors, Category category, Date  publishDate, boolean status, Timestamp createdAt) {
        this.id = id;
        this.title = title;
        this.ISBN = ISBN;
        this.bookImage = bookImage;
        this.authors = authors;
        this.category = category;
        this.publishDate = publishDate;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public List<Integer> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Integer> authors) {
        this.authors = authors;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", bookImage='" + bookImage + '\'' +
                ", authors=" + authors +
                ", category=" + category +
                ", publishDate=" + publishDate +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }
}
