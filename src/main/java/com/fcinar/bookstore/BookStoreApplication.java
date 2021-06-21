package com.fcinar.bookstore;

import com.fcinar.bookstore.model.Book;
import com.fcinar.bookstore.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner {
    private final BookRepository bookRepository;

    public BookStoreApplication(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 = new Book(null, "Yüzüklerin Efendisi", "Tolkien", 10.0, 10);
        Book book2 = new Book(null, "Son Dilek", "Sapkowski", 8.0, 15);
        Book book3 = new Book(null, "Vampir Günlükleri", "J.D. Smith", 5.0, 6);
        bookRepository.saveAll(Arrays.asList(book1, book2, book3));
    }
}
