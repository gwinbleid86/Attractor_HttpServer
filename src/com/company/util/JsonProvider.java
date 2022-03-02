package com.company.util;

import com.company.entity.Book;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonProvider {
    private final static Gson gson = new Gson();

    public static List<Book> getBooks() {
        Type listType = new TypeToken<ArrayList<Book>>() {
        }.getType();
        try (Reader reader = new FileReader("books2.json")) {
            List<Book> books = gson.fromJson(reader, listType);
            return books;
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public static void writeBooks(List<Book> books) throws IOException {
        try (Writer writer = new FileWriter("books.json")) {
            String json = gson.toJson(books);
            writer.write(json);
        }
    }
}
