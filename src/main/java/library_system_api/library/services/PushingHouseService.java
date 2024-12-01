package library_system_api.library.services;
import library_system_api.library.models.PushingHouse;
import library_system_api.library.models.enums.PushingHouseName;

import java.util.Set;

public interface PushingHouseService {

    public void createPushingHouse(PushingHouse pushingHouse);
    public void deletePushingHouseById(long pushingHouseId);
    public PushingHouse getPushingHouseById(long id);
    public Set<PushingHouse> getAllPushingHouses();
    public boolean hasPushingHouse(PushingHouseName pushingHouseName);
}
