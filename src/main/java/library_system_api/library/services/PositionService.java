package library_system_api.library.services;
import library_system_api.library.models.Position;
import library_system_api.library.models.enums.PositionType;

import java.util.Set;

public interface PositionService {
    public void createPosition(Position position);
    public void deletePositionById(long positionId);
    public Position getPositionById(long id);
    public Set<Position> getAllPositions();
    public boolean hasPosition(PositionType positionType);
}
