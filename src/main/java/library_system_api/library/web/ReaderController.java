package library_system_api.library.web;

import library_system_api.library.exceptions.EntityAlreadyExistInTheDatabaseException;
import library_system_api.library.exceptions.EntityNotFoundInDatabaseException;
import library_system_api.library.models.Reader;
import library_system_api.library.models.dtos.ReaderDTO;
import library_system_api.library.services.ReaderService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/readers")
public class ReaderController {
    private final ReaderService readerService;
    private final ModelMapper modelMapper;

    public ReaderController(ReaderService readerService, ModelMapper modelMapper) {
        this.readerService = readerService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public String createReader(@RequestBody ReaderDTO readerDTO){
        if(this.readerService.readReaderByEmail(readerDTO.getEmail()) != null){

            throw new EntityAlreadyExistInTheDatabaseException("Reader already added in db!");
        }

        this.readerService.createReader(this.modelMapper.map(readerDTO, Reader.class));
        return "Reader created successfully!";
    }

    @PutMapping("{id}")
    public String updateReader(@PathVariable(name = "id")long id,
            @RequestBody ReaderDTO readerDTO){
        if(this.readerService.readReaderById(id) == null){

            throw new EntityNotFoundInDatabaseException("Reader does not exist in db!");
        }
        Reader reader = this.readerService.readReaderById(id);
        reader.setFirstName(readerDTO.getFirstName());
        reader.setMiddleName(readerDTO.getMiddleName());
        reader.setLastName(readerDTO.getLastName());
        reader.setEmail(readerDTO.getEmail());

        this.readerService.updateReader(reader);
        return "Reader updated successfully!";
    }

    @DeleteMapping("{id}")
    public String deleteReader(@PathVariable(name = "id")long id){
        if(this.readerService.readReaderById(id) == null){

            throw new EntityNotFoundInDatabaseException("Reader does not exist in db!");
        }

        this.readerService.deleteReaderById(id);
        return "Reader deleted successfully!";
    }

    @GetMapping("{id}")
    public ReaderDTO getReader(@PathVariable(name = "id")long id){
        if(this.readerService.readReaderById(id) == null){

            throw new EntityNotFoundInDatabaseException("Reader does not exist in db!");
        }

        return this.modelMapper.map(this.readerService.readReaderById(id), ReaderDTO.class);
    }

    @GetMapping
    public Set<ReaderDTO> getAllReaders(){
        if(this.readerService.readAllReaders().isEmpty()){

            throw new EntityNotFoundInDatabaseException("Reader table is empty!");
        }

        return this.readerService
                .readAllReaders()
                .stream()
                .map(r -> modelMapper.map(r,ReaderDTO.class))
                .collect(Collectors.toSet());
    }
}
