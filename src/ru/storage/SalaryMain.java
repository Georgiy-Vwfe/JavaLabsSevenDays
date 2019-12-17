package ru.storage;

import ru.model.Employee;
import ru.salary.AbstractSalary;
import ru.salary.FixedSalary;
import ru.salary.HourlySalary;

import java.util.ArrayList;


public class SalaryMain {
    public static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        setup();
        System.out.println("After: " + AbstractSalary.readAll());
    }

    public static void setup() {
        AbstractSalary fixedSalary = new FixedSalary();
        AbstractSalary hourlySalary = new HourlySalary();
        for (int i = 0; i < 6; i++) {
            employees.add(new Employee(String.valueOf(i), String.valueOf((int) (Math.random() * 2))));
        }
        System.out.println("Before: " + employees.toString());

        for (Employee employee : employees) {
            switch (employee.getSalaryType()) {
                case "0":
                    fixedSalary.save(employee);
                    break;
                case "1":
                    hourlySalary.save(employee);
                    break;
                default:
                    System.out.println();
            }
        }
    }
}
