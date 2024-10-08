package com.Hexaware.expenses.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExpenseClaim {
    private Integer id;
    private Integer employeeId;
    private LocalDate dateOfClaim;
    private boolean approved;
    private boolean paid;
    private List<ExpenseItem> expenseItems;

    public ExpenseClaim(Integer id, Integer employeeId, LocalDate dateOfClaim) {
        this.id = id;
        this.employeeId = employeeId;
        this.dateOfClaim = dateOfClaim;
        this.approved = false;
        this.paid = false;
        this.expenseItems = new ArrayList<>();
    }

    public ExpenseClaim() {

    }

    public void addExpenseItem(ExpenseItem item){
        expenseItems.add(item);
    }


    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public void setPaid(boolean paid) {
        if(paid && !approved)
            System.out.println("This item cannot be paid as it has not yet been approved.");
        else
            this.paid = paid;
    }

    public Boolean getApproved() {
        return approved;
    }

    public Boolean getPaid() {
        return paid;
    }

    public Integer getId() {
        return id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public LocalDate getDateOfClaim() {
        return dateOfClaim;
    }

    public Double getTotalAmount() {
        Double totalAmount = 0d;
        for (ExpenseItem item: expenseItems){
            totalAmount += item.getAmount();
        }
        return totalAmount;
    }

    public List<ExpenseItem> getExpenseItems() {
        return expenseItems;
    }

    public boolean isApproved() {
        return approved;
    }

    public boolean isPaid() {
        return paid;
    }

    @Override
    public String toString() {
        return "ExpenseClaim{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", dateOfClaim='" + dateOfClaim + '\'' +
                ", approved=" + approved +
                ", paid=" + paid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpenseClaim that = (ExpenseClaim) o;
        return approved == that.approved && paid == that.paid && Objects.equals(id, that.id) && Objects.equals(employeeId, that.employeeId) && Objects.equals(dateOfClaim, that.dateOfClaim) && Objects.equals(expenseItems, that.expenseItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, dateOfClaim, approved, paid, expenseItems);
    }

    public void printExpenseItems(){
        for (ExpenseItem item : expenseItems){
            System.out.println(item);
        }
    }


}
