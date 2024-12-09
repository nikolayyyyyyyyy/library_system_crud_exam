package library_system_api.library.web;
import library_system_api.library.exceptions.EntityHaveNotReturnedBrowingsException;
import library_system_api.library.exceptions.EntityNotFoundInDatabaseException;
import library_system_api.library.models.Browing;
import library_system_api.library.models.dtos.BrowingDTO;
import library_system_api.library.models.dtos.GetBrowingDTO;
import library_system_api.library.services.BrowingService;
import library_system_api.library.services.EmployeeService;
import library_system_api.library.services.ReaderService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/browings")
public class BrowingController {
    private final BrowingService browingService;
    private final ReaderService readerService;
    private final EmployeeService employeeService;
    private final ModelMapper modelMapper;

    public BrowingController(BrowingService browingService, ReaderService readerService, EmployeeService employeeService, ModelMapper modelMapper) {
        this.browingService = browingService;
        this.readerService = readerService;
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public String createBrowing(@RequestBody BrowingDTO browingDTO){
        if(this.readerService.readReaderById(browingDTO.getReaderId()) == null){

            throw new EntityNotFoundInDatabaseException("Reader does not exist in db!");
        }

        if(!this.readerService
                .readReaderById(browingDTO.getReaderId()).getBrowings()
                .stream()
                .filter(a->!a.isReturned()).collect(Collectors.toSet())
                .isEmpty()){

            throw new EntityHaveNotReturnedBrowingsException("Reader have not returned browing!");
        }

        if(this.employeeService.readEmployee(browingDTO.getEmployeeId()) == null){

            throw new EntityNotFoundInDatabaseException("Employee not found in db!");
        }
        Browing browing = new Browing();
        mapBrowing(browingDTO, browing);

        this.browingService.createBrowing(browing);
        return "Browing created successfully!";
    }

    @PutMapping("{id}")
    public String updateBrowing(@PathVariable(name = "id")long id,
                                @RequestBody BrowingDTO browingDTO){
        if(this.browingService.getBrowing(id) == null){

            throw new EntityNotFoundInDatabaseException("Browing does not exist in db!");
        }

        if(this.readerService.readReaderById(browingDTO.getReaderId()) == null){

            throw new EntityNotFoundInDatabaseException("Reader does not exist in db!");
        }

        if(this.employeeService.readEmployee(browingDTO.getEmployeeId()) == null){

            throw new EntityNotFoundInDatabaseException("Employee not found in db!");
        }

        Browing browing = this.browingService.getBrowing(id);
        mapBrowing(browingDTO,browing);

        this.browingService.updateBrowing(browing);
        return "Browing updated successfully!";
    }

    @DeleteMapping("{id}")
    private String deleteBrowing(@PathVariable(name = "id")long id){
        if(this.browingService.getBrowing(id) == null){

            throw new EntityNotFoundInDatabaseException("Browing does not exist in db!");
        }

        this.browingService.deleteBrowing(id);
        return "Browing deleted successfully!";
    }

    @GetMapping("{id}")
    private GetBrowingDTO getBrowing(@PathVariable(name = "id")long id){
        if(this.browingService.getBrowing(id) == null){

            throw new EntityNotFoundInDatabaseException("Browing does not exist in db!");
        }
        Browing browing = this.browingService.getBrowing(id);

        return this.modelMapper.map(this.browingService.getBrowing(id),GetBrowingDTO.class);
    }

    @GetMapping
    public Set<GetBrowingDTO> getAllBrowings(){
        if(this.browingService.getAllBrowings().isEmpty()){
            throw new EntityNotFoundInDatabaseException("Browing table is empty!");
        }

        return this.browingService.getAllBrowings()
                .stream()
                .map(a -> modelMapper.map(a,GetBrowingDTO.class))
                .collect(Collectors.toSet());
    }

    private void mapBrowing(BrowingDTO browingDTO, Browing browing) {
        browing.setReader(this.readerService.readReaderById(browingDTO.getReaderId()));
        browing.setEmployee(this.employeeService.readEmployee(browingDTO.getEmployeeId()));
        browing.setTerm(browingDTO.getTerm());
        browing.setDateOfLoan(browingDTO.getDateOfLoan());
        browing.setReturned(browingDTO.isReturned());
    }
}