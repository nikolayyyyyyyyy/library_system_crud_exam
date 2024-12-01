package library_system_api.library.models.dtos;

import library_system_api.library.models.enums.PushingHouseName;

public class PushingHouseDTO {
    private PushingHouseName pushingHouseName;

    public PushingHouseDTO() {
    }

    public PushingHouseName getPushingHouseName() {
        return pushingHouseName;
    }

    public void setPushingHouseName(PushingHouseName pushingHouseName) {
        this.pushingHouseName = pushingHouseName;
    }
}
