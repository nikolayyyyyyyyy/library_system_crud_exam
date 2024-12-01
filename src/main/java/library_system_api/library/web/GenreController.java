package library_system_api.library.web;
import library_system_api.library.exceptions.EntityAlreadyExistInTheDatabaseException;
import library_system_api.library.exceptions.EntityNotFoundInDatabaseException;
import library_system_api.library.models.Genre;
import library_system_api.library.models.dtos.GenreDTO;
import library_system_api.library.services.GenreService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/genres")
public class GenreController {
    private final GenreService genreService;
    private final ModelMapper modelMapper;

    public GenreController(GenreService genreService, ModelMapper modelMapper) {
        this.genreService = genreService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public String createGenre(@RequestBody GenreDTO genreDTO){
        if(this.genreService.hasGenre(genreDTO.getGenreType())){

            throw new EntityAlreadyExistInTheDatabaseException("Genre already added!");
        }
        this.genreService.createGenre(this.modelMapper.map(genreDTO,Genre.class));
        return "Successfully created genre!";
    }

    @GetMapping("{id}")
    public GenreDTO readGenre(@PathVariable(name = "id") long id){
        if(this.genreService.getGenreById(id) == null){

            throw new EntityNotFoundInDatabaseException("Genre does not exist in db!");
        }

        return this.modelMapper.map(this.genreService.getGenreById(id),GenreDTO.class)  ;
    }

    @GetMapping
    public Set<GenreDTO> readAllGenres(){
        if(this.genreService.getAllGenres().isEmpty()){

            throw new EntityNotFoundInDatabaseException("Table Genres in empty!");
        }
        return this.genreService
                .getAllGenres()
                .stream()
                .map(genre -> modelMapper.map(genre,GenreDTO.class))
                .collect(Collectors.toSet());
    }

    @DeleteMapping("{id}")
    public String deleteGenre(@PathVariable(name = "id")long id){
        if(this.genreService.getGenreById(id) == null){

            throw new EntityNotFoundInDatabaseException("Genre does not exist in db!");
        }
        this.genreService.deleteGenreById(id);
        return "Genre deleted successfully!";
    }
}
