package bo.fin.api.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.fin.api.model.Expense;

@RestController
public class ExpenseController {
    @RequestMapping("/list-expenses")
    public List<Expense> getEmployees()
    {
        List<Expense> expenseList = new ArrayList<Expense>();
        expenseList.add(new Expense(1,"Breno","Strauss","breno_strauss@gmail.com"));
        return expenseList;
    }

}
