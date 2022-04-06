package com.ravi.library.controller;

import com.ravi.library.model.Book;
import com.ravi.library.model.RequestModel;
import com.ravi.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @RequestMapping(value = "/addbook", method = RequestMethod.POST)
    public ResponseEntity<String> addBook(@RequestBody Book book){
        String responseMessage;
        try{
            if(book.getTitle() == null || book.getTitle().isEmpty() || book.getAuthor() == null || book.getAuthor().isEmpty()
                    || book.getCategory() == null || book.getCategory().isEmpty())
                return new ResponseEntity<>("Please provide all mandatory request parameters.", HttpStatus.BAD_REQUEST);

            responseMessage = bookService.addBook(book);
        }
        catch(Exception e){
            responseMessage = e.getMessage();
        }
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @RequestMapping(value = "/deletebook", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteBook(@RequestBody RequestModel requestModel){
        String responseMessage;
        try{
            if(requestModel.getTitle() == null || requestModel.getTitle().isEmpty())
                return new ResponseEntity<>("Please provide all mandatory request parameters.", HttpStatus.BAD_REQUEST);

            responseMessage  = bookService.deleteBook(requestModel.getTitle());
        }
        catch(Exception e){
            responseMessage = e.getMessage();
        }
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @RequestMapping(value = "/outstandingbooks", method = RequestMethod.GET)
    public List<Book> getAllOutstandingBooks(){
        return bookService.getAllOutstandingBooks();
    }

}
