package library_system_api.library.repositories;

import library_system_api.library.models.PushingHouse;
import library_system_api.library.models.enums.PushingHouseName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PushingHouseRepository extends JpaRepository<PushingHouse,Long> {

    public PushingHouse findByPushingHouseName(PushingHouseName pushingHouseName);
}
