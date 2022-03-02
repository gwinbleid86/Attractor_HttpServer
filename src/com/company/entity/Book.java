package com.company.entity;

public class Book {
    private Integer id;
    private String title;
    private String description;
    private String author;
    private transient Boolean available = true;

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
//    private transient String imageLink;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getImageLink() {
//        return imageLink;
//    }
//
//    public void setImageLink(String imageLink) {
//        this.imageLink = imageLink;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
