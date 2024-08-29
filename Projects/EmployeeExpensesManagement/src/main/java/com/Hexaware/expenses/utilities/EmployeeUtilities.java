package com.Hexaware.expenses.utilities;

import com.Hexaware.expenses.Exceptions.InvalidEmployeeIdException;
import com.Hexaware.expenses.Exceptions.NameTooShortException;
import com.Hexaware.expenses.domain.Employee;
import com.Hexaware.expenses.domain.EmployeesInMemoryImpl;

public class EmployeeUtilities {
    public boolean employeeExists(Employee employee, EmployeesInMemoryImpl employees){
        return  employees.findBySurname(employee.getSurName()) != null;
    }

    public Integer validateEmployeeId(String value) throws InvalidEmployeeIdException{
        try{
            return Integer.valueOf(value);
        }
        catch (Exception e){
            throw new InvalidEmployeeIdException();
        }
    }

    public void validateEmployeeName(String firstName, String surName) throws NameTooShortException {
        int len = firstName.length() + surName.length();
        if(len < 6)
            throw new NameTooShortException();
    }
}
