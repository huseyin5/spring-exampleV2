package com.example.graphqlserver;

import java.util.Arrays;
import java.util.List;

public record Book(String id, String name, int pageCount, String authorId) {

    private static List<Book> books = Arrays.asList(
            new Book("book-1", "book-name-1", 416, "author-1"),
            new Book("book-2", "book-name-2", 416, "author-2"),
            new Book("book-3", "book-name-3", 416, "author-3")
    );

    public static Book getById(String id) {
        return books.stream().filter(book -> book.id().equals(id)).findFirst().orElse(null);
    }
}
