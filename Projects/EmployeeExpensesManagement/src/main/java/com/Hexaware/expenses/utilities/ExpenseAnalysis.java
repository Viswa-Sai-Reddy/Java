package com.Hexaware.expenses.utilities;

import com.Hexaware.expenses.domain.Employee;

import java.time.LocalDate;

public interface ExpenseAnalysis {
    public void printOutStandingExpenseClaim();

    public void printPaidExpenseClaim(LocalDate startDate, LocalDate endDate);
    public void printExpenseClaimOfAmount(Double amount);
}
