package com.Hexaware.expenses.management;

import com.Hexaware.expenses.domain.Employee;
import com.Hexaware.expenses.domain.ExpenseClaim;
import com.Hexaware.expenses.domain.StaffEmployee;
import com.Hexaware.expenses.management.ExpenseManagmentProcess;

import java.util.ArrayList;
import java.util.List;

public class RegularExpenseManagementProcess implements ExpenseManagmentProcess {

    List<ExpenseClaim> expenseClaims = new ArrayList<>();
    @Override
    public int registerExpenseClaim(ExpenseClaim claim) {
        expenseClaims.add(claim);
        return expenseClaims.size() - 1;
    }

    @Override
    public boolean approveClaim(int id, Employee approver) {
        ExpenseClaim foundClaim = expenseClaims.get(id);

        if(foundClaim.getTotalAmount() < 100)
            return true;
        else if (foundClaim.getTotalAmount() > 100 && approver instanceof StaffEmployee)
            return true;
        else
            return false;
    }
}
