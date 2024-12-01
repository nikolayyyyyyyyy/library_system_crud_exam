package library_system_api.library.services.impl;
import library_system_api.library.models.Position;
import library_system_api.library.models.enums.PositionType;
import library_system_api.library.repositories.PositionRepository;
import library_system_api.library.services.PositionService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;

    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public void createPosition(Position position) {
        this.positionRepository.save(position);
    }

    @Override
    public void deletePositionById(long positionId) {
        this.positionRepository.deleteById(positionId);
    }

    @Override
    public Position getPositionById(long id) {
        return this.positionRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Position> getAllPositions() {
        return new HashSet<>(this.positionRepository.findAll());
    }

    @Override
    public boolean hasPosition(PositionType positionType) {
        return this.positionRepository.findByPositionType(positionType) != null;
    }
}
