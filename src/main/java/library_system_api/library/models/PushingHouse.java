package library_system_api.library.models;

import jakarta.persistence.*;
import library_system_api.library.models.enums.PushingHouseName;

import java.util.Set;

@Entity
@Table(name = "pushing_houses")
public class PushingHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true,nullable = false)
    private PushingHouseName pushingHouseName;

    @OneToMany(mappedBy = "pushingHouse")
    private Set<Book> books;

    public PushingHouse() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PushingHouseName getPushingHouseName() {
        return pushingHouseName;
    }

    public void setPushingHouseName(PushingHouseName pushingHouse) {
        this.pushingHouseName = pushingHouse;
    }
}
