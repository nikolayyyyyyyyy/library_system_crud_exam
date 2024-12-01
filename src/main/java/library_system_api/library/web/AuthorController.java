package library_system_api.library.web;

import library_system_api.library.exceptions.EntityNotFoundInDatabaseException;
import library_system_api.library.exceptions.EntityAlreadyExistInTheDatabaseException;
import library_system_api.library.models.Author;
import library_system_api.library.models.dtos.AuthorDTO;
import library_system_api.library.services.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;
    private final ModelMapper modelMapper;

    public AuthorController(AuthorService authorService, ModelMapper modelMapper) {
        this.authorService = authorService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    public String createAuthor(@RequestBody AuthorDTO authorDTO){
        if(this.authorService.hasAuthor(authorDTO.getEmail())){

            throw new EntityAlreadyExistInTheDatabaseException("Entity is already added!");
        }
        this.authorService.createAuthor(this.modelMapper.map(authorDTO, Author.class));
        return "Author created successfully!";
    }

    @PutMapping("{id}")
    public String updateAuthor(@PathVariable(name = "id")long id,
                              @RequestBody AuthorDTO authorDTO){
        if(this.authorService.getAuthorById(id) == null){

            throw new EntityNotFoundInDatabaseException("Author does not exist in the database!");
        }
        Author author = this.authorService.getAuthorById(id);
        author.setAge(authorDTO.getAge());
        author.setFirstName(authorDTO.getFirstName());
        author.setMiddleName(authorDTO.getMiddleName());
        author.setLastName(authorDTO.getLastName());
        author.setEmail(authorDTO.getEmail());

        this.authorService.updateAuthor(author);
        return "Author updated successfully!";
    }

    @DeleteMapping("{id}")
    public String deleteAuthor(@PathVariable(name = "id")long id){
        if(this.authorService.getAuthorById(id) == null){

            throw new EntityNotFoundInDatabaseException("Author does not exist in the database!");
        }

        this.authorService.deleteAuthorById(id);
        return "Author deleted successfully!";
    }

    @GetMapping("{id}")
    public AuthorDTO readAuthor(@PathVariable(name = "id")long id){
        if(this.authorService.getAuthorById(id) == null){

            throw new EntityNotFoundInDatabaseException("Author does not exist in the database!");
        }

        return this.modelMapper.map(this.authorService.getAuthorById(id), AuthorDTO.class);
    }

    @GetMapping
    public Set<AuthorDTO> readAllAuthors(){
        if(this.authorService.getAllAuthors().isEmpty()){

            throw new EntityNotFoundInDatabaseException("Authors table empty!");
        }
        return this.authorService.getAllAuthors()
                .stream()
                .map(author -> this.modelMapper.map(author, AuthorDTO.class))
                .collect(Collectors.toSet());
    }
}
