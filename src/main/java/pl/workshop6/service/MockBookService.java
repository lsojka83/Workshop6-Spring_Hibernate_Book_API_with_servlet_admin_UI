package pl.workshop6.service;

import org.springframework.stereotype.Component;
import pl.workshop6.model.Book;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.stream.Collectors;

@Component
public class MockBookService implements BookService{

    private List<Book> list;
    private static Long nextId;


    public MockBookService(List<Book> list) {
        this.list = list;
    }

    public List<Book> getBooks() {
        return list;
    }

    public Optional<Book> getBookById(Long id) {
            Optional<Book> book = list.stream().filter(b -> b.getId().equals(id)).findFirst();
            return book;
    }

    public void addBook(Book book)
    {
        book.setId(generateNewId());
        list.add(book);
    }


    public boolean editBook(Book book) {
        if (checkIfBookByIdExists(book.getId())) {
            Book editedBook = getBookById(book.getId()).get();
            int index = list.indexOf(editedBook);
            list.set(index, book);
            return true;
        }
        return false;
    }

    public boolean deleteBook(Long id) {
        if (getBookById(id).isPresent()) {
            Book bookToBeDeleted = getBookById(id).get();
            list.remove(bookToBeDeleted);
            return true;
        } else {
            return false;
        }
    }

    public Long generateNewId() {
        OptionalLong nextIdOpt = list.stream().mapToLong(b -> b.getId()).max();
        if (nextIdOpt.isEmpty()) {
            nextId = 1l;
        } else {
            nextId = nextIdOpt.getAsLong() + 1;
        }
        return nextId;
    }

    public boolean checkIfBookByIdExists(Long id) {
        if (list.stream().filter(b -> b.getId() == id).collect(Collectors.toList()).size() > 0) {
            return true;
        }
        return false;
    }

}


