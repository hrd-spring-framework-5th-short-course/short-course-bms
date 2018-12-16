package com.example.shortcoursebms.models.responses;

public class BookResponse {

    private Integer id;

    private String title;

    private String ISBN;

    private String bookImage;

    private String categoryName;

    public BookResponse() {
    }

    public BookResponse(Integer id, String title, String ISBN, String bookImage, String categoryName) {
        this.id = id;
        this.title = title;
        this.ISBN = ISBN;
        this.bookImage = bookImage;
        this.categoryName = categoryName;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}


