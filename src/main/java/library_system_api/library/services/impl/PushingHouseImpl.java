package library_system_api.library.services.impl;
import library_system_api.library.models.PushingHouse;
import library_system_api.library.models.enums.PushingHouseName;
import library_system_api.library.repositories.PushingHouseRepository;
import library_system_api.library.services.PushingHouseService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PushingHouseImpl implements PushingHouseService {
    private final PushingHouseRepository pushingHouseRepository;

    public PushingHouseImpl(PushingHouseRepository pushingHouseRepository) {
        this.pushingHouseRepository = pushingHouseRepository;
    }

    @Override
    public void createPushingHouse(PushingHouse pushingHouse) {
        this.pushingHouseRepository.save(pushingHouse);
    }

    @Override
    public void deletePushingHouseById(long pushingHouseId) {
        this.pushingHouseRepository.deleteById(pushingHouseId);
    }

    @Override
    public PushingHouse getPushingHouseById(long id) {
        return this.pushingHouseRepository.findById(id).orElse(null);
    }

    @Override
    public Set<PushingHouse> getAllPushingHouses() {
        return new HashSet<>(this.pushingHouseRepository.findAll());
    }

    @Override
    public boolean hasPushingHouse(PushingHouseName pushingHouseName) {
        return this.pushingHouseRepository.findByPushingHouseName(pushingHouseName) != null;
    }
}
