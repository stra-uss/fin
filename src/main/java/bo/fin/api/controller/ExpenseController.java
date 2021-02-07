package bo.fin.api.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.fin.api.model.Expense;

@RestController
public class ExpenseController {
    @RequestMapping("/")
    public List<Expense> getEmployees()
    {
        List<Expense> employeesList = new ArrayList<Expense>();
        employeesList.add(new Expense(1,"Breno","Strauss","breno_strauss@gmail.com"));
        return employeesList;
    }

}
