package library_system_api.library.web;

import library_system_api.library.exceptions.EntityAlreadyExistInTheDatabaseException;
import library_system_api.library.exceptions.EntityNotFoundInDatabaseException;
import library_system_api.library.models.Book;
import library_system_api.library.models.dtos.BookDTO;
import library_system_api.library.models.dtos.GetBookDTO;
import library_system_api.library.services.AuthorService;
import library_system_api.library.services.BookService;
import library_system_api.library.services.GenreService;
import library_system_api.library.services.PushingHouseService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final PushingHouseService pushingHouseService;
    private final GenreService genreService;
    private final AuthorService authorService;
    private final ModelMapper modelMapper;

    public BookController(BookService bookService, PushingHouseService pushingHouseService, GenreService genreService, AuthorService authorService, ModelMapper modelMapper) {
        this.bookService = bookService;
        this.pushingHouseService = pushingHouseService;
        this.genreService = genreService;
        this.authorService = authorService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public String createBook(@RequestBody BookDTO bookDTO){
        if(this.bookService.getBookByName(bookDTO.getName()) != null){

            throw new EntityAlreadyExistInTheDatabaseException("Book already added in db!");
        }
        if(this.authorService.getAuthorById(bookDTO.getAuthorId()) == null){

            throw new EntityNotFoundInDatabaseException("Author does not exist in db!");
        }

        if(this.genreService.getGenreById(bookDTO.getGenreId()) == null){

            throw new EntityNotFoundInDatabaseException("Genre does not exist in db!");
        }

        if(this.pushingHouseService.getPushingHouseById(bookDTO.getPushingHouseId()) == null){

            throw new EntityNotFoundInDatabaseException("Pushing house does not exist in db!");
        }

        Book book = new Book();
        book.setName(bookDTO.getName());
        book.setPresent(bookDTO.isPresent());
        book.setPrice(bookDTO.getPrice());
        book.setDateOfIssue(bookDTO.getDateOfIssue());
        book.setPushingHouse(this.pushingHouseService.getPushingHouseById(bookDTO.getPushingHouseId()));
        book.setGenre(this.genreService.getGenreById(bookDTO.getGenreId()));
        book.setAuthor(this.authorService.getAuthorById(bookDTO.getAuthorId()));

        this.bookService.createBook(book);
        return "Book created successfully!";
    }

    @PutMapping("{id}")
    public String updateBook(@PathVariable(name = "id")long id
            ,@RequestBody BookDTO bookDTO){
        if(this.bookService.readBook(id) == null){

            throw new EntityNotFoundInDatabaseException("Book does not exist in db!");
        }

        if(this.authorService.getAuthorById(bookDTO.getAuthorId()) == null){

            throw new EntityNotFoundInDatabaseException("Author does not exist in db!");
        }

        if(this.genreService.getGenreById(bookDTO.getGenreId()) == null){

            throw new EntityNotFoundInDatabaseException("Genre does not exist in db!");
        }

        if(this.pushingHouseService.getPushingHouseById(bookDTO.getPushingHouseId()) == null){

            throw new EntityNotFoundInDatabaseException("Pushing house does not exist in db!");
        }

        Book book = this.bookService.readBook(id);
        book.setName(bookDTO.getName());
        book.setPresent(bookDTO.isPresent());
        book.setPrice(bookDTO.getPrice());
        book.setDateOfIssue(bookDTO.getDateOfIssue());
        book.setPushingHouse(this.pushingHouseService.getPushingHouseById(bookDTO.getPushingHouseId()));
        book.setGenre(this.genreService.getGenreById(bookDTO.getGenreId()));
        book.setAuthor(this.authorService.getAuthorById(bookDTO.getAuthorId()));

        this.bookService.createBook(book);
        return "Book updated successfully!";
    }

    @DeleteMapping("{id}")
    public String deleteBook(@PathVariable(name = "id")long id){
        if(this.bookService.readBook(id) == null){

            throw new EntityNotFoundInDatabaseException("Book does not exist in db!");
        }

        this.bookService.deleteBook(id);
        return "Book deleted successfully!";
    }

    @GetMapping("{id}")
    public GetBookDTO getBook(@PathVariable(name = "id")long id){
        if(this.bookService.readBook(id) == null){

            throw new EntityNotFoundInDatabaseException("Book does not exist in db!");
        }

        return this.modelMapper.map(this.bookService.readBook(id), GetBookDTO.class);
    }

    @GetMapping
    public Set<GetBookDTO> getAllBooks(){
        if(this.bookService.readAllBooks().isEmpty()){

            throw new EntityNotFoundInDatabaseException("Books table is empty!");
        }
        return this.bookService.readAllBooks()
                .stream()
                .map(b -> modelMapper.map(b, GetBookDTO.class))
                .collect(Collectors.toSet());
    }
}
