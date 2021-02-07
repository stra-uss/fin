package bo.fin.api.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.fin.api.model.Employee;

@RestController
public class EmployeeController {
    @RequestMapping("/")
    public List<Employee> getEmployees()
    {
        List<Employee> employeesList = new ArrayList<Employee>();
        employeesList.add(new Employee(1,"Breno","Strauss","breno_strauss@gmail.com"));
        return employeesList;
    }

}
