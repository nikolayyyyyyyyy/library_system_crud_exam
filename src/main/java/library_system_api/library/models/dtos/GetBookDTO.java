package library_system_api.library.models.dtos;
import java.time.LocalDate;

public class GetBookDTO {
    private String name;

    private LocalDate dateOfIssue;

    private double price;

    private boolean isPresent;

    private AuthorDTO author;

    private GenreDTO genre;

    private PushingHouseDTO pushingHouse;

    public GetBookDTO() {
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

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public GenreDTO getGenre() {
        return genre;
    }

    public void setGenre(GenreDTO genre) {
        this.genre = genre;
    }

    public PushingHouseDTO getPushingHouse() {
        return pushingHouse;
    }

    public void setPushingHouse(PushingHouseDTO pushingHouse) {
        this.pushingHouse = pushingHouse;
    }
}
