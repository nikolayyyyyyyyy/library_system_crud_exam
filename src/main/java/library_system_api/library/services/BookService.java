package library_system_api.library.services;

import library_system_api.library.models.Book;

import java.util.Set;

public interface BookService {

    public void createBook(Book book);
    public void deleteBook(long bookId);
    public void updateBook(Book book);
    public Book readBook(long id);
    public Set<Book> readAllBooks();
    public Book getBookByName(String name);
}
