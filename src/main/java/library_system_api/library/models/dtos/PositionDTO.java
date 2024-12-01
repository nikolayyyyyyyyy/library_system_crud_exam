package library_system_api.library.models.dtos;

import library_system_api.library.models.enums.PositionType;

public class PositionDTO {
    private PositionType positionType;

    public PositionDTO() {
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }
}
