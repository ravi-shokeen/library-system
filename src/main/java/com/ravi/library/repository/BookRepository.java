package com.ravi.library.repository;

import com.ravi.library.model.Book;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BookRepository {
    private HashMap<String, Book> books = new HashMap<>();

    public String addBook(@NotNull Book book){
        if(!books.containsKey(book.getTitle())){
            books.put(book.getTitle(), book);
            return "Book: " + book.getTitle() + " is added to the Library.";
        }
        else
            return "Book: " + book.getTitle() + " is already added to Library.";

    }

    public Book getBookByTitle(String title){
        return books.get(title);
    }

    public List<Book> getAllBooks(){
        return new ArrayList<>(books.values());
    }

    public String removeBook(String title){
        if(books.containsKey(title)){
            books.remove(title);
            return "Book: " + title + " is removed from the Library.";
        }else{
            return "Book: " + title + " is not found in Library";
        }
    }

    public List<Book> getAllOutstandingBooks(){
        List<Book> outStandingBooks = new ArrayList<>();
        List<Book> allBooks =  getAllBooks();
        for(Book book : allBooks){
            if(!book.getIsAvailable()){
                if(book.getIsBookOutstanding())
                    outStandingBooks.add(book);
            }
        }
        return outStandingBooks;
    }

}
