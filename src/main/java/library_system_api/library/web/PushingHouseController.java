package library_system_api.library.web;

import library_system_api.library.exceptions.EntityAlreadyExistInTheDatabaseException;
import library_system_api.library.exceptions.EntityNotFoundInDatabaseException;
import library_system_api.library.models.PushingHouse;
import library_system_api.library.models.dtos.PushingHouseDTO;
import library_system_api.library.services.PushingHouseService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pushing_houses")
public class PushingHouseController {
    private final PushingHouseService pushingHouseService;
    private final ModelMapper modelMapper;

    public PushingHouseController(PushingHouseService pushingHouseService, ModelMapper modelMapper) {
        this.pushingHouseService = pushingHouseService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public String createPushingHouse(@RequestBody PushingHouseDTO pushingHouseDTO){
        if(this.pushingHouseService.hasPushingHouse(pushingHouseDTO.getPushingHouseName())){

            throw new EntityAlreadyExistInTheDatabaseException("Pushing house already exist in db!");
        }

        this.pushingHouseService.createPushingHouse(this.modelMapper.map(pushingHouseDTO, PushingHouse.class));
        return "Pushing house added successfully!";
    }

    @DeleteMapping("{id}")
    public String deletePushingHouse(@PathVariable(name = "id")long id){
        if(this.pushingHouseService.getPushingHouseById(id) == null){

            throw new EntityNotFoundInDatabaseException("Pushing house does not exist in db!");
        }
        this.pushingHouseService.deletePushingHouseById(id);
        return "Pushing house deleted successfully!";
    }

    @GetMapping("{id}")
    public PushingHouseDTO readPushingHouse(@PathVariable(name = "id")long id){
        if(this.pushingHouseService.getPushingHouseById(id) == null){

            throw new EntityNotFoundInDatabaseException("Pushing house does not exist in db!");
        }

        return this.modelMapper.map(this.pushingHouseService.getPushingHouseById(id),PushingHouseDTO.class);
    }

    @GetMapping
    public Set<PushingHouseDTO> readAllPushingHouses(){
        if(this.pushingHouseService.getAllPushingHouses().isEmpty()){

            throw new EntityNotFoundInDatabaseException("Pushing house table is empty!");
        }

        return this.pushingHouseService
                .getAllPushingHouses()
                .stream()
                .map(pushingHouse -> modelMapper.map(pushingHouse,PushingHouseDTO.class))
                .collect(Collectors.toSet());
    }
}
