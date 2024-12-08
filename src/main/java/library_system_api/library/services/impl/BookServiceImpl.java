package library_system_api.library.services.impl;

import library_system_api.library.models.Book;
import library_system_api.library.repositories.BookRepository;
import library_system_api.library.services.BookService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void createBook(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public void deleteBook(long bookId) {
        this.bookRepository.deleteById(bookId);
    }

    @Override
    public void updateBook(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public Book readBook(long id) {
        return this.bookRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Book> readAllBooks() {
        return new HashSet<>(this.bookRepository.findAll());
    }

    @Override
    public Book getBookByName(String name) {
        return this.bookRepository.findByName(name);
    }
}
