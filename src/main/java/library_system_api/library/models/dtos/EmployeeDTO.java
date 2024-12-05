package library_system_api.library.models.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class EmployeeDTO {

    @NotNull
    @Size(min = 3,max = 50,message = "First name should be between 3 and 50 characters!")
    private String firstName;

    @NotNull
    @Size(min = 3,max = 50,message = "Middle name should be between 3 and 50 characters!")
    private String middleName;

    @NotNull
    @Size(min = 3,max = 50,message = "Last name should be between 3 and 50 characters!")
    private String lastName;

    @NotNull
    @Size(min = 5,max = 50,message = "Email should be between 5 and 50 characters!")
    private String email;

    @Positive
    private long positionId;

    public EmployeeDTO() {
    }

    public @NotNull @Size(min = 3, max = 50, message = "First name should be between 3 and 50 characters!") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotNull @Size(min = 3, max = 50, message = "First name should be between 3 and 50 characters!") String firstName) {
        this.firstName = firstName;
    }

    public @NotNull @Size(min = 3, max = 50, message = "Middle name should be between 3 and 50 characters!") String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(@NotNull @Size(min = 3, max = 50, message = "Middle name should be between 3 and 50 characters!") String middleName) {
        this.middleName = middleName;
    }

    public @NotNull @Size(min = 3, max = 50, message = "Last name should be between 3 and 50 characters!") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull @Size(min = 3, max = 50, message = "Last name should be between 3 and 50 characters!") String lastName) {
        this.lastName = lastName;
    }

    public @NotNull @Size(min = 5, max = 50, message = "Email should be between 5 and 50 characters!") String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @Size(min = 5, max = 50, message = "Email should be between 5 and 50 characters!") String email) {
        this.email = email;
    }

    @Positive
    public long getPositionId() {
        return positionId;
    }

    public void setPositionId(@Positive int positionId) {
        this.positionId = positionId;
    }
}
