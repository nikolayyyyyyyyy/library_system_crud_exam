package library_system_api.library.repositories;

import library_system_api.library.models.Browing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrowingRepository extends JpaRepository<Browing,Long> {
}
