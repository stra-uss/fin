package bo.fin.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.fin.api.exception.ResourceNotFoundException;
import bo.fin.api.model.Expense;
import bo.fin.api.repository.ExpenseRepository;

@RestController
@RequestMapping("/api/v1")
public class ExpenseController {
    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping("/list-expense")
    public List<Expense> getAllEmployees() {
        return expenseRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable(value = "id") Long expenseId)
        throws ResourceNotFoundException {
    	Expense expense = expenseRepository.findById(expenseId)
          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + expenseId));
        return ResponseEntity.ok().body(expense);
    }
    
    @PostMapping("/employees")
    public Expense createEmployee(@Valid @RequestBody Expense expense) {
        return expenseRepository.save(expense);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable(value = "id") Long expenseId,
         @Valid @RequestBody Expense expenseDetails) throws ResourceNotFoundException {
    	Expense expense = expenseRepository.findById(expenseId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + expenseId));

    	expense.setEmailId(expenseDetails.getEmailId());
    	expense.setLastName(expenseDetails.getLastName());
    	expense.setFirstName(expenseDetails.getFirstName());
        final Expense updatedExpense = expenseRepository.save(expense);
        return ResponseEntity.ok(updatedExpense);
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long expenseId)
         throws ResourceNotFoundException {
    	Expense expense = expenseRepository.findById(expenseId)
       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + expenseId));

    	expenseRepository.delete(expense);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}