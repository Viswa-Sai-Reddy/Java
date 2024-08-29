package com.Hexaware.expenses.domain;

import java.util.*;

public class    Employee implements Comparable<Employee> {
    private int id;
    private String title;
    private String surName;
    private String firstName;
    private String jobTitle;
    private Department department;
    private Map<Integer,ExpenseClaim> claims = new HashMap<>();

    public Employee() {
    }

    public Employee(int id, String title, String surName, String firstName, String jobTitle, Department department) {
        this.id = id;
        this.title = title;
        this.surName = surName;
        this.firstName = firstName;
        this.jobTitle = jobTitle;
        this.department = department;
    }

    public String getMaillingName() {
        return title + " " + surName + " " + firstName;
    }

    public String getMaillingName(boolean firstInitialOnly){
        if(firstInitialOnly)
            return title+" "+surName.substring(0,1)+" "+firstName;
        else
            return title + " " + surName + " " + firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSurName() {
        return surName;
    }

    public Map<Integer,ExpenseClaim> getClaims() {
        return claims;
    }

    public void setSurName(String surName) {
        if (surName.length() < 2)
            System.out.println("Error - SurName length should be greater than 2");
        else
            this.surName = surName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() < 3)
            System.out.println("Error - FirstName length should be greater than 3");
        else
            this.firstName = firstName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(title, employee.title) && Objects.equals(surName, employee.surName) && Objects.equals(firstName, employee.firstName) && Objects.equals(jobTitle, employee.jobTitle) && department == employee.department && Objects.equals(claims, employee.claims);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, surName, firstName, jobTitle, department, claims);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", surName='" + surName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", department=" + department +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return this.surName.compareTo(o.getSurName());
    }

    public void addClaim(ExpenseClaim claim){
        claims.put(claim.getId(), claim);
    }
}
