package com.ravi.library.service;

import com.ravi.library.model.Book;
import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    String addBook(Book book);

    String deleteBook(String title);

    List<Book> getAllOutstandingBooks();
}
