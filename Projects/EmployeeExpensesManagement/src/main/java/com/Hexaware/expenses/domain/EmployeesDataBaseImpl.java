package com.Hexaware.expenses.domain;

import com.Hexaware.expenses.Exceptions.EmployeeNotFoundException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeesDataBaseImpl implements Employees {

    public EmployeesDataBaseImpl() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
    }

    @Override
    public void addEmployee(Employee employee) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres")) {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO employees (id, title, firstName, surName, jobTitle, department)" + " VALUES (" + employee.getId() + ", '" + employee.getTitle() + "'," + "'" + employee.getFirstName() + "', '" + employee.getSurName() + "'," + "'" + employee.getJobTitle() + "', '" + employee.getDepartment() + "')";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("There is a problem while connecting the database");
            throw new RuntimeException(e);
        }
    }


    @Override
    public Employee findBySurname(String surName) {

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres")) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM employees WHERE surName like '%" + surName + "'");
            if (!rs.next()) return null;

            int id = rs.getInt("id");
            String title = rs.getString("title");
            String firstName = rs.getString("firstName");
            String jobTitle = rs.getString("jobTitle");
            Department department = Department.valueOf(rs.getString("department").toUpperCase());

            Employee employee = new Employee(id, title, surName, firstName, jobTitle, department);
            List<ExpenseClaim> claims = getExpenseClaimsForEmployee(id);
            claims.forEach(claim -> employee.addClaim(claim));
            return employee;


        } catch (SQLException e) {
            System.out.println("There is a problem while connecting the database");
            throw new RuntimeException(e);
        }

    }

    @Override
    public Employee findById(int id) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres")) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM employees WHERE id = '" + id + "'");
            if (!rs.next()) return null;

            String title = rs.getString("title");
            String surName = rs.getString("surName");
            String firstName = rs.getString("firstName");
            String jobTitle = rs.getString("jobTitle");
            Department department = Department.valueOf(rs.getString("department").toUpperCase());

            Employee employee = new Employee(id, title, surName, firstName, jobTitle, department);
            List<ExpenseClaim> claims = getExpenseClaimsForEmployee(id);
            claims.forEach(claim -> employee.addClaim(claim));
            return employee;

        } catch (SQLException e) {
            System.out.println("There is a problem while connecting the database");
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean findByExists(Integer employeeId) {
        return !(findById(employeeId) == null);
    }

    public void addExpenseItem(ExpenseItem item) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres")) {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO expenseitems (id, claimId, expenseType, description, amount) VALUES (" +
                    item.getId() + "," + item.getClaimId() + ",'" + item.getExpenseType().toString() + "','" + item.getDescription() + "'," +
                    item.getAmount() + ")";
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println("There is a problem while connecting the database");
            throw new RuntimeException(e);
        }

    }


    @Override
    public void addExpenseClaim(ExpenseClaim claim) throws EmployeeNotFoundException {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres")) {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO expenseclaims (id, employeeId, dateOfClaim, approved, paid) VALUES (" +
                    claim.getId() + "," + claim.getEmployeeId() + ",'" + claim.getDateOfClaim().toString() +
                    "'," + claim.getApproved() + "," + claim.getPaid() + ")";
            statement.executeUpdate(sql);

            claim.getExpenseItems().forEach(ei -> addExpenseItem(ei));
        } catch (SQLException e) {
            System.out.println("There is a problem while connecting the database");
            throw new RuntimeException(e);
        }
    }

    private List<ExpenseItem> getExpenseItemForClaim(int claimId) {
        List<ExpenseItem> itemList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres")) {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM expenseitems WHERE claimId = '" + claimId + "'";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String expenseType = rs.getString("expenseType");
                String description = rs.getString("description");
                Double amount = rs.getDouble("amount");

                ExpenseItem item = new ExpenseItem(id, claimId, ExpenseType.valueOf(expenseType.toUpperCase()), description, amount);


                itemList.add(item);
            }

        } catch (SQLException e) {
            System.out.println("There is a problem while connecting the database");
            throw new RuntimeException(e);
        }

        return itemList;
    }

    private List<ExpenseClaim> getExpenseClaimsForEmployee(int employeeId) {
        List<ExpenseClaim> claimsList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres")) {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM expenseclaims WHERE employeeId = '" + employeeId + "'";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String dateOfClaim = rs.getString("dateOfClaim");
                Boolean approved = rs.getBoolean("approved");
                Boolean paid = rs.getBoolean("paid");

                ExpenseClaim claims = new ExpenseClaim(id, employeeId, LocalDate.parse(dateOfClaim));
                claims.setApproved(approved);
                claims.setPaid(paid);
                List<ExpenseItem> expenseItems = getExpenseItemForClaim(id);
                expenseItems.forEach(ei -> claims.addExpenseItem(ei));
                claimsList.add(claims);
            }

        } catch (SQLException e) {
            System.out.println("There is a problem while connecting the database");
            throw new RuntimeException(e);
        }

        return claimsList;
    }

    @Override
    public List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres")) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM employees");
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String firstName = rs.getString("firstName");
                String surName = rs.getString("surName");
                String jobTitle = rs.getString("jobTitle");
                Department department = Department.valueOf(rs.getString("department").toUpperCase());

                Employee employee = new Employee(id, title, surName, firstName, jobTitle, department);
                List<ExpenseClaim> claims = getExpenseClaimsForEmployee(id);
                claims.forEach(claim -> employee.addClaim(claim));
                employeeList.add(employee);
            }

        } catch (SQLException e) {
            System.out.println("There is a problem while connecting the database");
            throw new RuntimeException(e);
        }

        return employeeList;
    }

    @Override
    public void printEmployee() {
        List<Employee> employeeList = getEmployeeList();
        Collections.sort(employeeList, (a, b) -> {
            if (a.getId() < b.getId()) return -1;
            else return 1;
        });
        for (Employee e : employeeList) {
            System.out.println(e);
            for (ExpenseClaim claim : e.getClaims().values()) {
                System.out.println(claim);
                claim.printExpenseItems();
                System.out.println("The total amount: " + claim.getTotalAmount());
            }
        }
    }

}
