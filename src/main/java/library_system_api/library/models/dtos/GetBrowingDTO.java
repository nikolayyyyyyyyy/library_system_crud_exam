package library_system_api.library.models.dtos;

import java.time.LocalDate;
import java.util.Set;

public class GetBrowingDTO {
    private GetEmployeeDTO employee;
    private ReaderDTO reader;
    private LocalDate dateOfLoan;
    private LocalDate term;
    private boolean isReturned;
    private Set<GetBookDTO> books;

    public GetBrowingDTO() {
    }

    public Set<GetBookDTO> getBooks() {
        return books;
    }

    public void setBooks(Set<GetBookDTO> books) {
        this.books = books;
    }

    public GetEmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(GetEmployeeDTO employee) {
        this.employee = employee;
    }

    public ReaderDTO getReader() {
        return reader;
    }

    public void setReader(ReaderDTO reader) {
        this.reader = reader;
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
