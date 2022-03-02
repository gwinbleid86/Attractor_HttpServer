package com.company.service;

import com.company.dto.BooksDataModel;
import com.company.entity.Book;
import com.company.util.JsonProvider;

public class BookService {
    private final BooksDataModel books = new BooksDataModel(JsonProvider.getBooks());

    public BookService() {
//        books.addAll(JsonProvider.getBooks());
    }

    public BooksDataModel getBooks() {
        return books;
    }

    public Book findBookById(String id) {
        var book = books.getBookList().stream().filter(e -> e.getId() == Integer.parseInt(id)).findFirst();
        try {
            if (book.isEmpty()) {
                throw new Exception("Such a book does not exist.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book.get();
    }
}
