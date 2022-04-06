package com.ravi.library;

import com.ravi.library.repository.BookRepository;
import com.ravi.library.repository.MemberRepository;
import com.ravi.library.service.BookService;
import com.ravi.library.service.BookServiceImpl;
import com.ravi.library.service.MemberService;
import com.ravi.library.service.MemberServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public BookRepository bookRepo(){
        return new BookRepository();
    }

    @Bean
    public MemberRepository memberRepo(){
        return new MemberRepository();
    }

    @Bean
    public MemberService memberService() { return new MemberServiceImpl(); }

    @Bean
    public BookService bookService() { return new BookServiceImpl(); }
}
