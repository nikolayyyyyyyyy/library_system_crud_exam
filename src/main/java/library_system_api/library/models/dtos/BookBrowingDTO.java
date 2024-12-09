package library_system_api.library.models.dtos;

public class BookBrowingDTO {
    private long bookId;
    private long browingId;

    public BookBrowingDTO() {
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getBrowingId() {
        return browingId;
    }

    public void setBrowingId(long browingId) {
        this.browingId = browingId;
    }
}
