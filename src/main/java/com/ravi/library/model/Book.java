package com.ravi.library.model;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class Book {

    private String title;
    private String author;
    private List<String> category;
    private long loanedBy;
    private LocalDate loanedDate;
    private LocalDate returnedDate;
    private boolean isAvailable;
    private boolean isBookOutstanding;

    public Book(){}

    public Book(String title, String author, List<String> category, long loanedBy, LocalDate loanedDate, LocalDate returnedDate){
        this.title = title;
        this.author = author;
        this.category = category;
        this.loanedBy = loanedBy;
        this.loanedDate = loanedDate;
        this.returnedDate = returnedDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public long getLoanedBy() {
        return loanedBy;
    }

    public void setLoanedBy(long loanedBy) {
        this.loanedBy = loanedBy;
    }

    public LocalDate getLoanedDate() {
        return loanedDate;
    }

    public void setLoanedDate(LocalDate loanedDate) {
        this.loanedDate = loanedDate;
    }

    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }

    public boolean getIsAvailable() {
        if(getLoanedBy() == 0)
            return true;
        return false;
    }

    public boolean getIsBookOutstanding(){
        if(getLoanedDate() != null){
            if(Duration.between(getLoanedDate().atStartOfDay(), LocalDate.now().atStartOfDay()).toDays() > 14){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Book{" + "title='" + title + '\'' + ", author='" + author + '\'' + '}';
    }
}
