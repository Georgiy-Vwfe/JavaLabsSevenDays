package ru.model;

public class Employee implements Comparable<Employee> {
    private String uuid;
    private String fullName;
    private String salaryInMonth;
    private String salaryType;

    public Employee(String uuid, String salaryInMonth, String salaryType) {
        this.uuid = uuid;
        this.salaryInMonth = salaryInMonth;
        this.salaryType = salaryType;
    }

    public Employee(String uuid, String salaryType) {
        this.uuid = uuid;
        fullName = "Employee number: " + uuid;
        this.salaryType = salaryType;
    }

    public Employee(String salaryType) {
        this.salaryType = salaryType;
    }

    public Employee() {
    }

    public String getUuid() {
        return uuid;
    }

    public String getSalaryType() {
        return salaryType;
    }

    @Override
    public int compareTo(Employee employee) {
        return salaryInMonth.compareTo(employee.salaryInMonth);
    }

    @Override
    public String toString() {
        return "\nuuid: " + uuid + "\nFull Name: " + fullName + "\nSalary In This Month: " + salaryInMonth + "\nSalary Type: " + salaryType + "\n";
    }
}
