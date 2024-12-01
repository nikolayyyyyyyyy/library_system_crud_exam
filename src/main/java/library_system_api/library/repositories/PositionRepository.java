package library_system_api.library.repositories;

import library_system_api.library.models.Position;
import library_system_api.library.models.enums.PositionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position,Long> {

    public Position findByPositionType(PositionType positionType);
}
