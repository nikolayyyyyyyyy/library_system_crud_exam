package library_system_api.library.repositories;
import library_system_api.library.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    public Author findByEmail(String email);
}
