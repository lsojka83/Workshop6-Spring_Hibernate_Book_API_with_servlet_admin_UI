package pl.workshop6.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.workshop6.model.Book;
import pl.workshop6.service.BookService;

import javax.persistence.EntityNotFoundException;

@Controller
public class AdminController {

    private final BookService bookService;

    public AdminController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public String landingPage()
    {
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getBooks());
        return "list";
    }


    @GetMapping("/list/{id}")
    public String showBook(Model model, @PathVariable long id) {
        model.addAttribute("book", bookService.getBookById(id).orElseThrow(EntityNotFoundException::new));
        return "show";
    }

    @GetMapping("/add")
    public String addBook() {

        return "add";
    }

    @PostMapping("/add")
    public String addBook(@RequestParam String addConfirmButton, @RequestParam String isbn, @RequestParam String title,
                          @RequestParam String author, @RequestParam String publisher, @RequestParam String type) {

        if (addConfirmButton.equals("yes")) {
            bookService.addBook(new Book(isbn, title, author, publisher, type));
        }
        return "redirect:/list";
    }

    @GetMapping("/edit")
    public String editBook(Model model, @RequestParam String id) {

        if (bookService.getBookById(Long.valueOf(id)).isPresent()) {
            System.out.println("EDIT" + id + "GET");
            model.addAttribute("book", bookService.getBookById(Long.valueOf(id)).get());
            return "edit";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }


    @PostMapping("/edit")
    public String addBook(Book book, @RequestParam String editConfirmButton, @RequestParam String id, @RequestParam String isbn, @RequestParam String title,
                          @RequestParam String author, @RequestParam String publisher, @RequestParam String type) {
        System.out.println("EDIT" + id + "POST");

        if (editConfirmButton.equals("yes")) {
            bookService.editBook(book);
        }
        return "redirect:/list";
    }

    @GetMapping("/delete")
    public String deleteBook(Model model, @RequestParam String id) {
        System.out.println("DELETE" + id);
        if (bookService.getBookById(Long.valueOf(id)).isPresent()) {

            model.addAttribute("book", bookService.getBookById(Long.valueOf(id)).get());
            return "delete";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @PostMapping("/delete")
    public String deleteBook(@RequestParam String deleteConfirmButton, @RequestParam String id) {
        System.out.println("DELETE" + id + "POST");

        if (deleteConfirmButton.equals("yes")) {
            bookService.deleteBook(Long.valueOf(id));
        }
        return "redirect:/list";
    }





}
