package library_system_api.library.repositories;

import library_system_api.library.models.Genre;
import library_system_api.library.models.enums.GenreType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Long> {

    public Genre findByGenreType(GenreType genreType);
}
