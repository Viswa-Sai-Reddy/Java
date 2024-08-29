package com.Hexaware.expenses.management;

import com.Hexaware.expenses.domain.Employee;
import com.Hexaware.expenses.domain.ExpenseClaim;

public interface ExpenseManagmentProcess {

    public int registerExpenseClaim(ExpenseClaim expenseClaim);
    public boolean approveClaim(int id, Employee approver);
}
