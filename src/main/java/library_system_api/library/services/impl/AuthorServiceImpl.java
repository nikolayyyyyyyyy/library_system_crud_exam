package library_system_api.library.services.impl;
import library_system_api.library.models.Author;
import library_system_api.library.repositories.AuthorRepository;
import library_system_api.library.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
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
    public Author getAuthorById(long id) {
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
    public void deleteAuthorById(long id) {
        this.authorRepository.deleteById(id);
    }

    @Override
    public void updateAuthor(Author author) {
        this.authorRepository.save(author);
    }

    @Override
    public boolean hasAuthor(String email) {
        return this.authorRepository.findByEmail(email) != null;
    }
}
