package library_system_api.library.web;
import library_system_api.library.exceptions.EntityAlreadyExistInTheDatabaseException;
import library_system_api.library.exceptions.EntityNotFoundInDatabaseException;
import library_system_api.library.models.Employee;
import library_system_api.library.models.dtos.EmployeeDTO;
import library_system_api.library.models.dtos.GetEmployeeDTO;
import library_system_api.library.services.EmployeeService;
import library_system_api.library.services.PositionService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final PositionService positionService;
    private final ModelMapper modelMapper;

    public EmployeeController(EmployeeService employeeService, PositionService positionService, ModelMapper modelMapper) {
        this.employeeService = employeeService;
        this.positionService = positionService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public String createEmployee(@RequestBody EmployeeDTO employeeDTO){
        if(this.employeeService.exist(employeeDTO.getEmail()) != null){

            throw new EntityAlreadyExistInTheDatabaseException("Employee already added in db!");
        }

        if(this.positionService.getPositionById(employeeDTO.getPositionId()) == null){

            throw new EntityNotFoundInDatabaseException("Position does not exist in db!");
        }

        Employee employee = new Employee();
        mapEmployee(employeeDTO, employee);

        this.employeeService.createEmployee(employee);
        return "Employee created successfully!";
    }

    @PutMapping("{id}")
    public String updateEmployee(@PathVariable(name = "id")long id,
                                 @RequestBody EmployeeDTO employeeDTO){
        if(this.employeeService.readEmployee(id) == null){

            throw new EntityNotFoundInDatabaseException("Employee does not exist in db!");
        }

        if(this.positionService.getPositionById(employeeDTO.getPositionId()) == null){

            throw new EntityNotFoundInDatabaseException("Position does not exist in db!");
        }

        Employee employee = this.employeeService.readEmployee(id);
        mapEmployee(employeeDTO, employee);

        this.employeeService.updateEmployee(employee);
        return "Employee updated successfully!";
    }

    @DeleteMapping("{id}")
    public String deleteEmployee(@PathVariable(name = "id")long id){
        if(this.employeeService.readEmployee(id) == null){

            throw new EntityNotFoundInDatabaseException("Employee does not exist in db!");
        }

        this.employeeService.deleteEmployee(id);
        return "Employee deleted successfully!";
    }

    @GetMapping("{id}")
    public GetEmployeeDTO readEmployee(@PathVariable(name = "id")long id){
        if(this.employeeService.readEmployee(id) == null){

            throw new EntityNotFoundInDatabaseException("Employee does not exist in db!");
        }

        return this.modelMapper.map(this.employeeService.readEmployee(id), GetEmployeeDTO.class);
    }

    @GetMapping
    public Set<GetEmployeeDTO> readAllEmployees(){
        if(this.employeeService.readAllEmployees().isEmpty()){

            throw new EntityNotFoundInDatabaseException("Employee table empty!");
        }

        return this.employeeService.readAllEmployees()
                .stream()
                .map(e -> modelMapper.map(e, GetEmployeeDTO.class))
                .collect(Collectors.toSet());
    }

    private void mapEmployee(EmployeeDTO employeeDTO, Employee employee) {
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setMiddleName(employeeDTO.getMiddleName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPosition(this.positionService.getPositionById(employeeDTO.getPositionId()));
    }
}
