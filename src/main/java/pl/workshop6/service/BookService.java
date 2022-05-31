package pl.workshop6.service;

import pl.workshop6.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getBooks();

    Optional<Book> getBookById(Long id);

    void addBook(Book book);

    boolean editBook(Book book);

    boolean deleteBook(Long id);

    boolean checkIfBookByIdExists(Long id);
}
