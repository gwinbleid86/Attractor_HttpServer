package com.company.lesson44;

import com.company.entity.Book;
import com.company.service.BookService;
import com.company.util.Utils;
import com.sun.net.httpserver.HttpExchange;

import java.util.Map;
import java.util.stream.Collectors;

public class Webinar23Server extends Lesson47Server {
    private final BookService bookService = new BookService();

    public Webinar23Server(String host, int port) throws Exception {
        super(host, port);
        registerGet("/books", this::registerBooksHandler);
        registerGet("/book", this::registerBookHandlerGet);
        registerPost("/book", this::registerBookHandlerPost);
        registerGet("/profile", this::profileHandler);
    }

    private void profileHandler(HttpExchange exchange) {
        var user = users.get(0);
        renderTemplate(exchange, "profile.html", user);
    }

    private void registerBookHandlerPost(HttpExchange exchange) {
        String raw = getBody(exchange);
        Map<String, String> parsed = Utils.parseUrlEncoded(raw, "&");
        var user = users.stream().filter(c -> c.getEmail().equals(parsed.get("email"))).collect(Collectors.toList()).get(0);

        var book = bookService.findBookById(parsed.get("id"));
        book.setAvailable(false);
        user.setTackedBooks(book);

        try {
            registerBooksHandler(exchange);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void registerBookHandlerGet(HttpExchange exchange) {
        String queryParams = getQueryParams(exchange);

        Map<String, String> params = Utils.parseUrlEncoded(queryParams, "&");

        Book book = new Book();
        try {
            book = bookService.findBookById(params.get("id"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        renderTemplate(exchange, "book.ftl", book);
    }

    private void registerBooksHandler(HttpExchange exchange) {
        var dataModel = bookService.getBooks();

        renderTemplate(exchange, "books.ftl", dataModel);
    }

}
