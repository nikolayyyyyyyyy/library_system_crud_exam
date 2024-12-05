package library_system_api.library.services;

import library_system_api.library.models.Employee;

import java.util.Set;

public interface EmployeeService {

    public void createEmployee(Employee employee);
    public void updateEmployee(Employee employee);
    public void deleteEmployee(long id);
    public Employee readEmployee(long id);
    public Set<Employee> readAllEmployees();
    public Employee exist(String email);
}
