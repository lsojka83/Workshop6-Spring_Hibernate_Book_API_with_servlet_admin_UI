package pl.workshop6.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.workshop6.model.Book;
import pl.workshop6.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class DBBookService implements BookService{

    private final BookRepository bookRepository;


    public DBBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
            return bookRepository.findById(id);
    }

    public void addBook(Book book)
    {
        bookRepository.save(book);
    }


    public boolean editBook(Book book) {
        if (checkIfBookByIdExists(book.getId())) {
            bookRepository.save(book);
            return true;
        }
        return false;
    }

    public boolean deleteBook(Long id) {
        if (getBookById(id).isPresent()) {
           bookRepository.delete(bookRepository.findById(id).get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkIfBookByIdExists(Long id) {
       return bookRepository.findById(id).isPresent();
    }
}


