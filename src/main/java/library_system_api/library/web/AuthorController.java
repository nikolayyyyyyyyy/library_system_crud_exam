package library_system_api.library.web;
import library_system_api.library.models.Author;
import library_system_api.library.models.dtos.AuthorDTO;
import library_system_api.library.services.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;
    private final ModelMapper modelMapper;

    public AuthorController(AuthorService authorService, ModelMapper modelMapper) {
        this.authorService = authorService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public String createAuthor(@RequestBody AuthorDTO model){
        if(this.authorService.hasAuthor(this.modelMapper.map(model, Author.class))){

            throw new IllegalArgumentException("Author already exist in database!");
        }

        if(model.getAge() <= 0
                || model.getFirstName() == null
                || model.getLastName() == null
                || model.getMiddleName() == null){

            throw new IllegalArgumentException("Model not correct!");
        }

        return "";
    }
}
