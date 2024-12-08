package library_system_api.library.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "browings")
public class Browing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(mappedBy = "browings")
    private Set<Book> books;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;

    @Column(name = "number_of_browing")
    private String numberOfBrowing;

    @Column(name = "is_returned",nullable = false)
    private boolean isReturned;

    public Browing() {
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }

    public String getNumberOfBrowing() {
        return numberOfBrowing;
    }

    public void setNumberOfBrowing(String numberOfBrowing) {
        this.numberOfBrowing = numberOfBrowing;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }
}
