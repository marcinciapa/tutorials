package com.github.marcinciapa.SpringBootJooqTutorial;

import com.github.marcinciapa.SpringBootJooqTutorial.generated.tables.pojos.Book;
import com.github.marcinciapa.SpringBootJooqTutorial.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/books")
public class SpringBootJooqTutorialApplication {

    @Autowired
    private BookService service;

    @PostMapping
    public String addBook(@RequestBody Book book) {
        service.insertBook(book);
        return "book added...";
    }

    @GetMapping
    public List<Book> getBooks() {
        return service.getBooks();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJooqTutorialApplication.class, args);
    }

}
