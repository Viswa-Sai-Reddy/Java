package com.Hexaware.expenses.utilities;

import com.Hexaware.expenses.domain.Employee;

import java.time.LocalDate;

public class ExpenseAnalysisTempImpl implements ExpenseAnalysis{

    @Override
    public void printOutStandingExpenseClaim() {
        System.out.println("this feature is not currently available");
    }

    @Override
    public void printPaidExpenseClaim(LocalDate startDate, LocalDate endDate) {
        System.out.println("this feature is not currently available");
    }

    @Override
    public void printExpenseClaimOfAmount(Double amount) {
        System.out.println("this feature is not currently available");
    }
}
