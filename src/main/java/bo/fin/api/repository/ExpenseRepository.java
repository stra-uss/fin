package bo.fin.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bo.fin.api.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
