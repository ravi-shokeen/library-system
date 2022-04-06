package com.ravi.library.service;

import com.ravi.library.model.Book;
import com.ravi.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepo;

    @Override
    public List<Book> getAllBooks(){
        return bookRepo.getAllBooks();
    }

    @Override
    public String addBook(Book book){
           return bookRepo.addBook(book);
    }

    @Override
    public String deleteBook(String title){
            return bookRepo.removeBook(title);
    }

    @Override
    public List<Book> getAllOutstandingBooks(){
        return bookRepo.getAllOutstandingBooks();
    }
}
