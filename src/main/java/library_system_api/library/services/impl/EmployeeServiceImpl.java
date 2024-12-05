package library_system_api.library.services.impl;

import library_system_api.library.models.Employee;
import library_system_api.library.repositories.EmployeeRepository;
import library_system_api.library.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void createEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(long id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public Employee readEmployee(long id) {
        return this.employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Employee> readAllEmployees() {
        return new HashSet<>(this.employeeRepository.findAll());
    }

    @Override
    public Employee exist(String email) {
        return this.employeeRepository.findByEmail(email);
    }
}
