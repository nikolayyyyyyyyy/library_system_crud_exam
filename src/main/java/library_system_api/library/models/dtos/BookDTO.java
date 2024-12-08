package library_system_api.library.models.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class BookDTO {
    private String name;
    private LocalDate dateOfIssue;
    private double price;
    @JsonProperty("isPresent")
    private boolean isPresent;
    private long authorId;
    private long genreId;
    private long pushingHouseId;

    public BookDTO() {
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

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    public long getPushingHouseId() {
        return pushingHouseId;
    }

    public void setPushingHouseId(long pushingHouseId) {
        this.pushingHouseId = pushingHouseId;
    }
}
