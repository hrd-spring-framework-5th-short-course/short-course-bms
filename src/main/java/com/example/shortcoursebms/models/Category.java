package com.example.shortcoursebms.models;

import org.hibernate.validator.constraints.Length;

import java.sql.Timestamp;
import java.util.List;

public class Category {

    private Integer id;

    @Length(max = 30)
    private String name;

    private List<Book> books;

    private boolean status;

    private Timestamp createdAt;

    public Category() {
    }

    public Category(Integer id, String name, boolean status, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }
}
