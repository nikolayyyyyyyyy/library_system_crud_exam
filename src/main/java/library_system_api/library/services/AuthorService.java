package library_system_api.library.services;

import library_system_api.library.models.Author;

import java.util.Set;


public interface AuthorService {

    public void createAuthor(Author author);
    public Author getAuthor(long id);
    public Set<Author> getAllAuthors();
    public void deleteAuthor(long id);
    public void updateAuthor(Author author);
    public boolean hasAuthor(Author author);
}
