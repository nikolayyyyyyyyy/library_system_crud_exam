package library_system_api.library.repositories;

import library_system_api.library.models.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<Reader,Long> {

    public Reader findByEmail(String email);
}
