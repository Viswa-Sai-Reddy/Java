package com.Hexaware.expenses.domain;

import java.util.Objects;

public class StaffEmployee extends Employee implements Comparable<Employee>{

    private String userName;
    private String passWord;

    public StaffEmployee(Employee e){
        super(e.getId(),e.getTitle(),e.getSurName(),e.getFirstName(),e.getJobTitle(),e.getDepartment());
    }

    public StaffEmployee(){
        super();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StaffEmployee that = (StaffEmployee) o;
        return Objects.equals(userName, that.userName) && Objects.equals(passWord, that.passWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userName, passWord);
    }

}
