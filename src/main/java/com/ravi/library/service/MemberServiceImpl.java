package com.ravi.library.service;

import com.ravi.library.model.Book;
import com.ravi.library.model.Member;
import com.ravi.library.repository.BookRepository;
import com.ravi.library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.time.*;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberRepository memberRepo;

    @Autowired
    private BookRepository bookRepo;

    @Override
    public List<Member> getAllMembers() {
        return memberRepo.getAllMembers();
    }

    @Override
    public Member getMemberById(long memberId) {
        return memberRepo.getMemberByMemberId(memberId);
    }

    @Override
    public String loanBook(long memberId, String bookTitle) {
        Member member = memberRepo.getMemberByMemberId(memberId);
        Book book = bookRepo.getBookByTitle(bookTitle);
        String responseMessage;
        if(member == null || book == null) {
            responseMessage = member == null ? "Member is not found." : "Book is not found.";
            return responseMessage;
        }
        List<String> loanedBooks;
        loanedBooks = member.getLoanedBooks();
        if(getMembersWithOutstandingBook().contains(memberId)){
            responseMessage = "Member has outstanding book. Please return all outstanding books before lending a book.";
        }
        else if(!book.getIsAvailable())
            responseMessage = "Book is not available to loan";
        else if(loanedBooks.size() < 3){
            loanedBooks.add(book.getTitle());
            member.setLoanedBooks(loanedBooks);
            book.setLoanedBy(member.getMemberId());
            book.setLoanedDate(LocalDate.now());
            book.setReturnedDate(null);
            responseMessage = "Book: " + book.getTitle() + " is loaned to " + member.getName() + " successfully.";
        }
        else
            responseMessage = "Member: " + member.getName() + " has loaned 3 books already. Please return a book first.";

        return responseMessage;
    }

    @Override
    public String returnBook(long memberId, String bookTitle) {
        Member member = memberRepo.getMemberByMemberId(memberId);
        Book book = bookRepo.getBookByTitle(bookTitle);
        String responseMessage;
        if(member == null || book == null) {
            responseMessage = member == null ? "Member is not found." : "Book is not found.";
            return responseMessage;
        }
        List<String> loanedBooks;
        loanedBooks = member.getLoanedBooks();

        if(loanedBooks.contains(bookTitle)){
            loanedBooks.remove(book.getTitle());
            member.setLoanedBooks(loanedBooks);
            book.setLoanedBy(0);
            book.setReturnedDate(LocalDate.now());
            book.setLoanedDate(null);
            responseMessage = "Book: " + book.getTitle() + " is returned by " + member.getName() + " successfully.";
        }
        else
            responseMessage = "Member: " + member.getName() + " does not have the book to return.";

        return responseMessage;
    }

    private List<Long> getMembersWithOutstandingBook(){
        List<Long> membersWithOutstandingBook = new ArrayList<>();
        List<Book> outStandingBooks = bookRepo.getAllOutstandingBooks();
        for(Book book : outStandingBooks){
            membersWithOutstandingBook.add(book.getLoanedBy());
        }

        return membersWithOutstandingBook;
    }
}
