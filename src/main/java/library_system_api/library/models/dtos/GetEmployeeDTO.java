package library_system_api.library.models.dtos;

public class GetEmployeeDTO {
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private PositionDTO position;

    public GetEmployeeDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PositionDTO getPosition() {
        return position;
    }

    public void setPosition(PositionDTO positionDTO) {
        this.position = positionDTO;
    }
}
