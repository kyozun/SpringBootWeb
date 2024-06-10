package service;

import com.cuong.springbootweb.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(long id);

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee, long id);

    void deleteEmployee(long id);
}