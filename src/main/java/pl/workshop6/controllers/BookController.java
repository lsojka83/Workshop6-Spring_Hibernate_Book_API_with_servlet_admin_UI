package pl.workshop6.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.workshop6.model.Book;
import pl.workshop6.service.BookService;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<Book> books() {
        return bookService.getBooks();
    }

    @PostMapping("")
    public String addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return "Book added";
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        });
    }

    @PutMapping("")
    public String editBook(@RequestBody Book book) {
        if (bookService.editBook(book)) {
            return "Book edited";
        }
        return "No such book";
    }

    @DeleteMapping("/{id}")
    public String deleteBookById(@PathVariable Long id) {
        if (bookService.deleteBook(id)) {
            return "Book deleted";
        }
        return "No such book";
    }

}
