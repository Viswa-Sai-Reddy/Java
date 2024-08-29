package com.Hexaware.expenses.utilities;

import com.Hexaware.expenses.domain.Employees;
import com.Hexaware.expenses.domain.EmployeesInMemoryImpl;

import java.time.LocalDate;

public class ExpenseAnalysisImpl implements ExpenseAnalysis{
    private Employees employees;

    public ExpenseAnalysisImpl(Employees employees) {
        this.employees = employees;
    }

    @Override
    public void printOutStandingExpenseClaim() {
        employees.getEmployeeList().stream().forEach( employee -> {
            employee.getClaims().values().stream().
                    filter(claim -> !claim.isApproved()).
                    forEach(claim-> System.out.println(claim));
        });

    }

    @Override
    public void printPaidExpenseClaim(LocalDate startDate, LocalDate endDate) {

        employees.getEmployeeList().stream().forEach(employee -> {
            employee.getClaims().values().stream().
                    filter(claims -> claims.getDateOfClaim().isAfter(startDate) && claims.getDateOfClaim().isBefore(endDate)).
                    forEach(claim -> System.out.println(claim));
        });

    }

    @Override
    public void printExpenseClaimOfAmount(Double amount) {
        employees.getEmployeeList().stream().forEach(employee -> {
            employee.getClaims().values().stream().
                    filter(claims -> claims.getTotalAmount() > amount).
                    forEach(claim -> System.out.println(claim));
        });

    }
}
