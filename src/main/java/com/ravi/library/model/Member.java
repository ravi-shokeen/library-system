package com.ravi.library.model;

import java.util.List;

public class Member {


    private long memberId;
    private String name;
    private List<String> loanedBooks;

    public Member(){}

    public Member(long memberId, String name, List<String> loanedBooks){
        this.memberId = memberId;
        this.name = name;
        this.loanedBooks = loanedBooks;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLoanedBooks() {
        return loanedBooks;
    }

    public void setLoanedBooks(List<String> loanedBooks) {
        this.loanedBooks = loanedBooks;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                '}';
    }
}
