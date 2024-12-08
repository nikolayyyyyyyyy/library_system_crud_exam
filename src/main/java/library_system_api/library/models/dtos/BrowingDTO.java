package library_system_api.library.models.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

public class BrowingDTO {

    private long employeeId;

    private long readerId;

    private String numberOfBrowing;

    private LocalDate dateOfLoan;

    private LocalDate term;

    @JsonProperty("isReturned")
    private boolean isReturned;

    public BrowingDTO() {
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getReaderId() {
        return readerId;
    }

    public void setReaderId(long readerId) {
        this.readerId = readerId;
    }

    public String getNumberOfBrowing() {
        return numberOfBrowing;
    }

    public void setNumberOfBrowing(String numberOfBrowing) {
        this.numberOfBrowing = numberOfBrowing;
    }

    public LocalDate getDateOfLoan() {
        return dateOfLoan;
    }

    public void setDateOfLoan(LocalDate dateOfLoan) {
        this.dateOfLoan = dateOfLoan;
    }

    public LocalDate getTerm() {
        return term;
    }

    public void setTerm(LocalDate term) {
        this.term = term;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }
}
