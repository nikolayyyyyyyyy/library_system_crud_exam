package library_system_api.library.services;

import library_system_api.library.models.Author;

import java.util.Set;


public interface AuthorService {

    public void createAuthor(Author author);
    public Author getAuthorById(long id);
    public Set<Author> getAllAuthors();
    public void deleteAuthorById(long id);
    public void updateAuthor(Author author);
    public boolean hasAuthor(String email);
}
