package library_system_api.library.services.impl;

import library_system_api.library.models.Genre;
import library_system_api.library.models.enums.GenreType;
import library_system_api.library.repositories.GenreRepository;
import library_system_api.library.services.GenreService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public void createGenre(Genre genre) {
        this.genreRepository.save(genre);
    }

    @Override
    public void deleteGenreById(long genreId) {
        this.genreRepository.deleteById(genreId);
    }

    @Override
    public Genre getGenreById(long id) {
        return this.genreRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public Set<Genre> getAllGenres() {
        return new HashSet<>(this.genreRepository
                .findAll());
    }

    @Override
    public boolean hasGenre(GenreType genreType) {
        return this.genreRepository.findByGenreType(genreType) != null;
    }
}
