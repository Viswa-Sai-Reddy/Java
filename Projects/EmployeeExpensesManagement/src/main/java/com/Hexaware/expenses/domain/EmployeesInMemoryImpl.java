package com.Hexaware.expenses.domain;

import com.Hexaware.expenses.Exceptions.EmployeeNotFoundException;

import java.util.*;

public class EmployeesInMemoryImpl implements Employees {
    private Map<Integer,Employee> employees = new HashMap<>();

    public EmployeesInMemoryImpl() {
    }

    @Override
    public void addEmployee(Employee employee) {
            employees.put(employee.getId(),employee);

    }

    @Override
    public void printEmployee() {
        List<Employee> employeeList = new ArrayList<>(employees.values());
        Collections.sort(employeeList);
        for (Employee e : employeeList) {
            System.out.println(e);
            for (ExpenseClaim claim : e.getClaims().values()){
                System.out.println(claim);
                claim.printExpenseItems();
                System.out.println("The total amount: "+ claim.getTotalAmount());
            }
        }
    }

    @Override
    public Employee findBySurname(String surName) {
        for (Employee e : employees.values())
            if (e.getSurName().equalsIgnoreCase(surName))
                return e;
        return null;
    }

    @Override
    public Employee findById(int id) {
        return employees.get(id);
    }

    @Override
    public boolean findByExists(Integer id) {
        return employees.containsKey(id);
    }

    @Override
    public void addExpenseClaim(ExpenseClaim expenseClaim) throws EmployeeNotFoundException {
        int employeeId = expenseClaim.getEmployeeId();

        if (!findByExists(employeeId))
            throw new EmployeeNotFoundException();

        for (Employee e : employees.values()) {
            if (e.getId() == employeeId)
                e.getClaims().put(expenseClaim.getId(),expenseClaim);
        }
    }

    @Override
    public List<Employee> getEmployeeList(){
        return new ArrayList<>(employees.values());
    }
}
