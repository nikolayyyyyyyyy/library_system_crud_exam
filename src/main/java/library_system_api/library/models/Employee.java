package library_system_api.library.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name",nullable = false,length = 50)
    private String firstName;

    @Column(name = "middle_name",nullable = false,length = 50)
    private String middleName;

    @Column(name = "last_name",nullable = false,length = 50)
    private String lastName;

    @OneToMany(mappedBy = "employee")
    private Set<Browing> browings;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    public Employee() {
    }

    public Set<Browing> getBrowings() {
        return browings;
    }

    public void setBrowings(Set<Browing> browings) {
        this.browings = browings;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
