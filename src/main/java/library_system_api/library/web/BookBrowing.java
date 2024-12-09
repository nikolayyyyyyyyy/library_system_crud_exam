package library_system_api.library.web;

import library_system_api.library.exceptions.EntityNotFoundInDatabaseException;
import library_system_api.library.models.Book;
import library_system_api.library.models.Browing;
import library_system_api.library.models.dtos.BookBrowingDTO;
import library_system_api.library.services.BookService;
import library_system_api.library.services.BrowingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books_browings")
public class BookBrowing {
    private final BookService bookService;
    private final BrowingService browingService;

    public BookBrowing(BookService bookService, BrowingService browingService) {
        this.bookService = bookService;
        this.browingService = browingService;
    }

    @PostMapping
    public String createBookBrowing(@RequestBody BookBrowingDTO
                                     browingDTO) {
        if (this.bookService.readBook(browingDTO.getBookId()) == null) {

            throw new EntityNotFoundInDatabaseException("Book does not exist in db!");
        }

        if (!this.bookService.readBook(browingDTO.getBookId()).isPresent()) {

            throw new EntityNotFoundInDatabaseException("Book is not present!");
        }

        if (this.browingService.getBrowing(browingDTO.getBrowingId()) == null) {

            throw new EntityNotFoundInDatabaseException("Browing does not exist in db!");
        }

        Book book = this.bookService.readBook(browingDTO.getBookId());
        book.setPresent(false);

        Browing browing = this.browingService.getBrowing(browingDTO.getBrowingId());
        browing.getBooks().add(book);
        book.getBrowings().add(browing);

        this.browingService.updateBrowing(browing);
        this.bookService.updateBook(book);

        return "Book Browing successfully!";
    }
}
