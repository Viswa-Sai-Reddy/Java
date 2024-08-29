package com.Hexaware.expenses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SetUpDataBase {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres")){
            Statement statement = connection.createStatement();
//            String sql = "CREATE TABLE employees (id Integer,title VARCHAR(225),surName VARCHAR(225),firstName VARCHAR(225),jobTitle VARCHAR(225),department VARCHAR(225),"+"PRIMARY KEY (id))";
//            statement.executeUpdate(sql);
            String expenseClaimSQL = "CREATE TABLE expenseclaims (id INTEGER, employeeId INTEGER, dateOfClaim VARCHAR(255), approved BOOLEAN, paid BOOLEAN, PRIMARY KEY (id) )";
            String expenseItemSQL = "CREATE TABLE expenseitems (id INTEGER, claimId INTEGER, expenseType VARCHAR(255), description VARCHAR(255), amount DOUBLE PRECISION, PRIMARY KEY (id) )";

            statement.executeUpdate(expenseClaimSQL);
            statement.executeUpdate(expenseItemSQL);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
