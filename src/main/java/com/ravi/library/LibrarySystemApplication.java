package com.ravi.library;

import com.ravi.library.model.Book;
import com.ravi.library.model.Member;
import com.ravi.library.repository.BookRepository;
import com.ravi.library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class LibrarySystemApplication {

	@Autowired
	private BookRepository bookRepo;

	@Autowired
	private MemberRepository memberRepo;

	public static void main(String[] args) {
		SpringApplication.run(LibrarySystemApplication.class, args);
	}

	@PostConstruct
	public void initApplication(){
		bookRepo.addBook(new Book("Book 1","Demo Author", Arrays.asList("Category1", "Category2"),
				1, LocalDate.of(2022, 04, 02), null));
		bookRepo.addBook(new Book("Book 2","Demo Author", Arrays.asList("Category1"),
				2, LocalDate.of(2022, 04, 02), null));
		bookRepo.addBook(new Book("Book 3","Demo Author", Arrays.asList("Category2"),
				1, LocalDate.of(2022, 03, 02), null));
		bookRepo.addBook(new Book("Book 4","Demo Author", Arrays.asList("Category1","Category2","Category3"),
				0, null, null));
		bookRepo.addBook(new Book("Book 5","Demo Author", Arrays.asList("Category1","Category3"),
				0, null, null));
		bookRepo.addBook(new Book("Book 6","Demo Author", Arrays.asList("Category2","Category4"),
				0, null, null));
		bookRepo.addBook(new Book("Book 7","Demo Author", Arrays.asList("Category2","Category4","Category5"),
				0, null, null));
		bookRepo.addBook(new Book("Book 8","Demo Author", Arrays.asList("Category3","Category5"),
				0, null, null));

		memberRepo.addMember(new Member(1, "Member1", new ArrayList<>(Arrays.asList("Book 1", "Book 3"))));
		memberRepo.addMember(new Member(2, "Member2", new ArrayList<>(Arrays.asList("Book 2"))));
		memberRepo.addMember(new Member(3, "Member3", new ArrayList<>(Arrays.asList())));
	}

}
