package com.ravi.library.service;

import com.ravi.library.model.Member;

import java.util.List;

public interface MemberService {

    List<Member> getAllMembers();

    Member getMemberById(long memberId);

    String loanBook(long memberId, String bookTitle);

    String returnBook(long memberId, String bookTitle);
}
