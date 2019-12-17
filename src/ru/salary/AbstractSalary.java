package ru.salary;

import ru.model.Employee;
import ru.storage.ArrayListStorage;

import java.util.ArrayList;


public abstract class AbstractSalary {
    private static final int RATE_PER_HOUR = 250;
    private static final int FIXED_PAYMENT = 46000;
    private static final double TAX = 0.87;
    private static ArrayListStorage employeeList = new ArrayListStorage();

    protected static int getRatePerHour() {
        return RATE_PER_HOUR;
    }

    protected static int getFixedPayment() {
        return FIXED_PAYMENT;
    }

    protected static double getTAX() {
        return TAX;
    }

    public void save(Employee employee) {
        employeeList.saveEntity(new Employee(employee.getUuid(), salaryCalculation(), employee.getSalaryType()));
    }

    public static ArrayList<Employee> readAll(){
        return employeeList.getSortedEmployeeList();
    }

    protected abstract String salaryCalculation();
}
