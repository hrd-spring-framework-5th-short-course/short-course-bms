package com.example.shortcoursebms.models;

import java.sql.Timestamp;
import java.util.List;

public class Author {

    private Integer id;

    private String name;

    private String contact;

    private List<Book> books;

    private boolean status;

    private Timestamp createdAt;


    public Author() {
    }

    public Author(Integer id, String name, String contact, boolean status, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.contact = contact;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
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
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", books=" + books +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }
}
