package library_system_api.library.services.impl;
import library_system_api.library.models.Author;
import library_system_api.library.repositories.AuthorRepository;
import library_system_api.library.services.AuthorService;
import java.util.HashSet;
import java.util.Set;

public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void createAuthor(Author author) {
        this.authorRepository.save(author);
    }

    @Override
    public Author getAuthor(long id) {
        return this.authorRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public Set<Author> getAllAuthors() {
        return new HashSet<>(this.authorRepository
                .findAll());
    }

    @Override
    public void deleteAuthor(long id) {
        this.authorRepository.deleteById(id);
    }

    @Override
    public void updateAuthor(Author author) {
        this.authorRepository.save(author);
    }

    @Override
    public boolean hasAuthor(Author author) {
        return this.authorRepository.findAll()
                .stream().anyMatch(Author::equals);
    }
}
