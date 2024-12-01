package library_system_api.library.web;
import library_system_api.library.exceptions.EntityAlreadyExistInTheDatabaseException;
import library_system_api.library.exceptions.EntityNotFoundInDatabaseException;
import library_system_api.library.models.Position;
import library_system_api.library.models.dtos.PositionDTO;
import library_system_api.library.services.PositionService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/positions")
public class PositionController {
    private final PositionService positionService;
    private final ModelMapper modelMapper;

    public PositionController(PositionService positionService, ModelMapper modelMapper) {
        this.positionService = positionService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public String createPosition(@RequestBody PositionDTO positionDTO){
        if(this.positionService.hasPosition(positionDTO.getPositionType())){

            throw new EntityAlreadyExistInTheDatabaseException("Position already added!");
        }
        this.positionService.createPosition(this.modelMapper.map(positionDTO, Position.class));
        return "Successfully created position!";
    }

    @GetMapping("{id}")
    public PositionDTO readPosition(@PathVariable(name = "id") long id){
        if(this.positionService.getPositionById(id) == null){

            throw new EntityNotFoundInDatabaseException("Position does not exist in db!");
        }

        return this.modelMapper.map(this.positionService.getPositionById(id),PositionDTO.class)  ;
    }

    @GetMapping
    public Set<PositionDTO> readAllPositions(){
        if(this.positionService.getAllPositions().isEmpty()){

            throw new EntityNotFoundInDatabaseException("Table Positions in empty!");
        }
        return this.positionService
                .getAllPositions()
                .stream()
                .map(position -> modelMapper.map(position,PositionDTO.class))
                .collect(Collectors.toSet());
    }

    @DeleteMapping("{id}")
    public String deletePosition(@PathVariable(name = "id")long id){
        if(this.positionService.getPositionById(id) == null){

            throw new EntityNotFoundInDatabaseException("Position does not exist in db!");
        }
        this.positionService.deletePositionById(id);
        return "Position deleted successfully!";
    }
}
