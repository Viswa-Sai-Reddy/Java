package com.Hexaware.expenses;

import com.Hexaware.expenses.domain.*;
import com.Hexaware.expenses.domain.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.*;
import java.time.LocalDate;

import static java.lang.Class.forName;

public class Main {
    public static void main(String[] args) throws JsonProcessingException, ClassNotFoundException, SQLException {
        Employee employee1 = new Employee(1, "Mr", "Nadipannagari", "Viswa", "Tester", Department.CSE);
        Employee employee2 = new Employee(2, "Mr", "Sake", "Vamsi", "Tester", Department.ECE);
        Employee employee4 = new Employee(5, "Mr", "Nadipannagari", "Viswa", "Tester", Department.CSE);

        System.out.println("ID: " + employee1.getId());
        System.out.println(employee1.getTitle() + " " + employee1.getSurName() + " " + employee1.getFirstName());
        System.out.println(employee1.getJobTitle());
        System.out.println(employee1.getDepartment());

        System.out.println(employee1.getMaillingName());
        System.out.println(employee1.getMaillingName(true));
        System.out.println(employee1.getMaillingName(false));

        ExpenseClaim expenseClaim = new ExpenseClaim(123, 12442, LocalDate.now());

        ExpenseItem expenseItem = new ExpenseItem(24, 102, ExpenseType.MEAL, "The grand hotel is nice in MEALs", 12.4);
        System.out.println(expenseItem.getDescription());

        EmployeesInMemoryImpl employees = new EmployeesInMemoryImpl();
        employees.addEmployee(employee1);
        employees.addEmployee(employee2);
        employees.addEmployee(new Employee(3, "Mr", "Sake", "Gowtham", "Dev", Department.IT));

        employees.printEmployee();

        System.out.println("Employee found by database");
        Employee foundEmployee = employees.findBySurname("Vamsi");
        System.out.println(foundEmployee.getMaillingName());

        System.out.println(employee1); // = System.out.println(employee1.toString());
        System.out.println(employee1.equals(employee4));

//        UIFunctions uiFunctions = new UIFunctions();
//        uiFunctions.registerNewEmployee();

        ObjectMapper objectMapper = new ObjectMapper();
        String employeeJson = objectMapper.writeValueAsString(employee1);
        System.out.println(employeeJson);

        Class.forName("org.postgresql.Driver");
        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres")) {
            Statement statement = connection.createStatement();
          //  statement.executeUpdate("CREATE TABLE customer (id INTEGER,name VARCHAR(255),age INTEGER, PRIMARY KEY (id))");
            statement.executeUpdate("INSERT INTO customer (id,name,age) VALUES (2,'Sai',23)");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM customer");

            while(resultSet.next()){
                System.out.println(resultSet.getInt("id")+" "+ resultSet.getString("name")+" "+resultSet.getInt("age"));
            }
        }
    }
}
