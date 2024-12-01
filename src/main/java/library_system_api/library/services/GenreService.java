package library_system_api.library.services;
import library_system_api.library.models.Genre;
import library_system_api.library.models.enums.GenreType;

import java.util.Set;

public interface GenreService {

    public void createGenre(Genre genre);
    public void deleteGenreById(long genreId);
    public Genre getGenreById(long id);
    public Set<Genre> getAllGenres();
    public boolean hasGenre(GenreType genreType);
}