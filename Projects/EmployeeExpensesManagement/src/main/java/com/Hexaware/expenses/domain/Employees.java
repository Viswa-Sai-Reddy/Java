package com.Hexaware.expenses.domain;

import com.Hexaware.expenses.Exceptions.EmployeeNotFoundException;

import java.util.List;

public interface Employees {
    void addEmployee(Employee employee);

    void printEmployee();

    Employee findBySurname(String surName);

    Employee findById(int id);

    boolean findByExists(Integer id);

    void addExpenseClaim(ExpenseClaim expenseClaim) throws EmployeeNotFoundException;

    List<Employee> getEmployeeList();
}
