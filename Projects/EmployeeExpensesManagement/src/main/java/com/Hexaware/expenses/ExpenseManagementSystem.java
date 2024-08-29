package com.Hexaware.expenses;

import com.Hexaware.expenses.Exceptions.EmployeeNotFoundException;
import com.Hexaware.expenses.domain.*;
import com.Hexaware.expenses.management.ExpenseManagmentProcess;
import com.Hexaware.expenses.management.ExpressExpenseManagmentProcess;
import com.Hexaware.expenses.management.RegularExpenseManagementProcess;
import com.Hexaware.expenses.ui.UIFunctions;
import com.Hexaware.expenses.utilities.ExpenseAnalysisImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ExpenseManagementSystem {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        Employees employees = new EmployeesDataBaseImpl();
//        Employees employees1 = new EmployeesInMemoryImpl();
        UIFunctions uiFunctions = new UIFunctions();

        ExpenseManagmentProcess expressEMP = new ExpressExpenseManagmentProcess();
        ExpenseManagmentProcess regularEMP = new RegularExpenseManagementProcess();
        ExpenseAnalysisImpl expenseAnalysis = new ExpenseAnalysisImpl(employees);


        boolean readyToExit = false;
        while (!readyToExit) {
            System.out.println("Expense Management System");
            System.out.println("-------------------------");
            System.out.println("e - Register new Employee");
            System.out.println("c - Register new Claim");
            System.out.println("p - Print all Employees");
            System.out.println("f - Store the employee details into File");
            System.out.println("a - Approve Claim");
            System.out.println("po - Print OutStanding ExpenseClaims");
            System.out.println("pa - Print Paid ExpenseClaims");
            System.out.println("ps - Print Expense Claim above specified amount");
            System.out.println("x - Exit");

            String option = scanner.nextLine();
            scanner.nextLine();

            switch (option) {
                case "e":
                    Employee e = uiFunctions.registerNewEmployee();
                    employees.addEmployee(e);
                    break;
                case "c":
                    ExpenseClaim claim = uiFunctions.registerNewExpenseClaim();
                    try {
                        employees.addExpenseClaim(claim);
                        expressEMP.registerExpenseClaim(claim);
                        int id = regularEMP.registerExpenseClaim(claim);
                        System.out.println("The claim had been registered with id " + id);
                    } catch (EmployeeNotFoundException ex) {
                        System.out.println("There is no employee with id " + claim.getEmployeeId());
                    }
                    break;
                case "p":
                    employees.printEmployee();
                    break;
                case "f":
                    List<Employee> employeeList = employees.getEmployeeList();
                    Path reports = Paths.get(System.getProperty("user.home") + File.separator + "EmployeeFile.txt");
                    String lineTerminator = System.getProperty("line.separator");
                    Collections.sort(employeeList, (a, b) -> {
                        if (a.getId() < b.getId()) return -1;
                        else return 1;
                    });
                    for (Employee emp : employeeList) {
                        Files.writeString(reports, emp.toString() + lineTerminator, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                        for (ExpenseClaim empclaim : emp.getClaims().values()) {
                            Files.writeString(reports, empclaim.toString() + lineTerminator, StandardOpenOption.APPEND);
                            List<String> claimData = empclaim.getExpenseItems().stream().map(ei -> ei.toString()).toList();
                            Files.write(reports, claimData, StandardOpenOption.APPEND);
                            Files.writeString(reports, "The total amount: " + empclaim.getTotalAmount() + lineTerminator, StandardOpenOption.APPEND);
                        }
                    }
                case "x":
                    readyToExit = true;
                    break;
                case "a":
                    System.out.println("Enter Claim id");
                    int claimId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter Employee id");
                    int employeeId = scanner.nextInt();
                    scanner.nextLine();

                    Employee foundEmployee = employees.findById(employeeId);

                    System.out.println("Enter R for Regular and E for Express ");
                    String claimType = scanner.nextLine();

                    ExpenseManagmentProcess requestedProcess;

                    if (claimType.equalsIgnoreCase("r"))
                        requestedProcess = regularEMP;
                    else
                        requestedProcess = expressEMP;


                    boolean result = requestedProcess.approveClaim(claimId, foundEmployee);
                    System.out.println("The result was " + result);


                    break;
                case "po":
                    expenseAnalysis.printOutStandingExpenseClaim();
                    break;
                case "pa":
                    System.out.println("Enter the Start Date");
                    String date = scanner.nextLine();
                    LocalDate startdate = LocalDate.parse(date);
                    System.out.println("Enter the End Date");
                    date = scanner.nextLine();
                    LocalDate endDate = LocalDate.parse(date);
                    expenseAnalysis.printPaidExpenseClaim(startdate, endDate);
                    break;
                case "ps":
                    System.out.println("Enter the specific amount");
                    Double amount = scanner.nextDouble();
                    expenseAnalysis.printExpenseClaimOfAmount(amount);
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }
    }
}
