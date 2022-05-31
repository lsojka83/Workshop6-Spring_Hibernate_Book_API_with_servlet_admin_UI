package pl.workshop6.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.workshop6.model.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
}
