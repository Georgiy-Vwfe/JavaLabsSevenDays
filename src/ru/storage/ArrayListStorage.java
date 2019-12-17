package ru.storage;

import ru.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class ArrayListStorage {
    private List<Employee> employees = new ArrayList<>();

    public void saveEntity(Employee employee) {
        employees.add(employee);
    }

    public ArrayList<Employee> getSortedEmployeeList() {
        ArrayList<Employee> sortedEmployees = new ArrayList(employees);
        sortedEmployees.sort(Employee::compareTo);
        return sortedEmployees;
    }
}
