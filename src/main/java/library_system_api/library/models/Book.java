package library_system_api.library.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true,nullable = false,length = 100)
    private String name;

    @Column(name = "date_of_issue",nullable = false)
    private LocalDate dateOfIssue;

    @Column(nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "pushing_house_id")
    private PushingHouse pushingHouse;

    @ManyToMany
    @JoinTable(
            name = "books_browings",
            joinColumns = @JoinColumn(name = "book_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "browing_id",referencedColumnName = "id")
    )
    private Set<Browing> browings;

    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public PushingHouse getPushingHouse() {
        return pushingHouse;
    }

    public void setPushingHouse(PushingHouse pushingHouse) {
        this.pushingHouse = pushingHouse;
    }

    public Set<Browing> getBrowings() {
        return browings;
    }

    public void setBrowings(Set<Browing> browings) {
        this.browings = browings;
    }
}
