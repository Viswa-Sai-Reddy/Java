package com.Hexaware.expenses.ui;

import com.Hexaware.expenses.Exceptions.InvalidEmployeeIdException;
import com.Hexaware.expenses.Exceptions.NameTooShortException;
import com.Hexaware.expenses.domain.*;
import com.Hexaware.expenses.utilities.EmployeeUtilities;

import java.time.LocalDate;
import java.util.Scanner;

public class UIFunctions {
    public Employee registerNewEmployee() {
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();
        EmployeeUtilities employeeUtilities = new EmployeeUtilities();


        boolean valid = false;
        while (!valid) {
            System.out.println("Enter Employee ID: ");
            String empId = scanner.nextLine();
            try {
                Integer id = employeeUtilities.validateEmployeeId(empId);
                employee.setId(id);
                valid = true;
            } catch (InvalidEmployeeIdException e) {
                System.out.println("There is no employee with id: "+ empId);
            }
        }
        System.out.println("Enter Employee Title :");
        employee.setTitle(scanner.nextLine());

        valid = false;
        while (!valid) {
            System.out.println("Enter Employee SurName: ");
            String surname = scanner.nextLine();
            System.out.println("Enter Employee FirstName");
            String firstName = scanner.nextLine();
            try {
                employeeUtilities.validateEmployeeName(surname, firstName);
                employee.setSurName(surname);
                employee.setFirstName(firstName);
                valid = true;
            } catch (NameTooShortException e) {

            }
        }

        System.out.println("Enter Employee JobTitle: ");
        employee.setJobTitle(scanner.nextLine());

        valid = false;
        while (!valid) {
            System.out.println("Enter Employee Department: ");
            String dep = scanner.nextLine();
            try {
                Department department = Department.valueOf(dep.toUpperCase());
                employee.setDepartment(department);
                valid = true;
            } catch (Exception e) {
                System.out.println("Entered a invalid department - retry once again");
            }

        }

        System.out.println("Is this staff employee? Y/N");
        String staffEmp = scanner.nextLine();
        if(staffEmp.equalsIgnoreCase("y")){
            StaffEmployee staffEmployee = new StaffEmployee(employee);

            System.out.println("Enter UserName");
            String username = scanner.nextLine();
            staffEmployee.setUserName(username);

            System.out.println("Enter Password");
            String password = scanner.nextLine();
            staffEmployee.setPassWord(password);

            return staffEmployee;
        }
        else
            return employee;
    }

    public ExpenseClaim registerNewExpenseClaim() {
        Scanner scanner = new Scanner(System.in);
        EmployeeUtilities employeeUtilities = new EmployeeUtilities();

        System.out.println("Enter ExpenseClaim id");
        int claimId = scanner.nextInt();

        System.out.println("Enter ExpenseClaim EmployeeID");
        int empId = scanner.nextInt();

        LocalDate localDate = LocalDate.now();

//        System.out.println("Enter ExpenseClaim amount");
//        double amount = scanner.nextDouble();

        ExpenseClaim expenseClaim = new ExpenseClaim(claimId, empId, localDate);

        boolean finished = false;
        while(!finished){
            System.out.println("Enter Expense Item id");
            int eiID = scanner.nextInt();
            scanner.nextLine();

            boolean expenseItemValid = false;
            ExpenseType type = null;

            while(!expenseItemValid){
                System.out.println("Enter Expense Item Type");
                String expenseType = scanner.nextLine();
                try{
                    type = ExpenseType.valueOf(expenseType.toUpperCase());
                    expenseItemValid = true;
                }catch(IllegalArgumentException e){
                    System.out.println("The Expense type you entered is invalid - retry once again");
                }
            }

            System.out.println("Enter the description for Expense Item");
            String descriptionOfItem = scanner.nextLine();

            System.out.println("Enter ExpenseClaim amount");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            ExpenseItem expenseItem = new ExpenseItem(eiID,claimId,type,descriptionOfItem,amount);
            expenseClaim.addExpenseItem(expenseItem);


            System.out.println("Do you want to enter another Expense Claim: Y/N");
            String anotherClaim = scanner.nextLine();

            if(anotherClaim.equalsIgnoreCase("n"))
                finished = true;

        }

        return expenseClaim;
    }

}
