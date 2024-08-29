package com.Hexaware.expenses.management;

import com.Hexaware.expenses.domain.Employee;
import com.Hexaware.expenses.domain.ExpenseClaim;
import com.Hexaware.expenses.management.ExpenseManagmentProcess;

public class ExpressExpenseManagmentProcess implements ExpenseManagmentProcess {

    private ExpenseClaim expenseClaim;
    @Override
    public int registerExpenseClaim(ExpenseClaim claim) {
        this.expenseClaim = claim;
        return -1;
    }

    @Override
    public boolean approveClaim(int id, Employee approver) {

        return expenseClaim.getTotalAmount() < 50;
    }
}
