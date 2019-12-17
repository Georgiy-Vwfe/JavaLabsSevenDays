package ru.salary;

public class HourlySalary extends AbstractSalary {
    public static final int hours = 184;

    @Override
    protected String salaryCalculation() {
        return String.valueOf(hours * AbstractSalary.getRatePerHour() * AbstractSalary.getTAX());
    }
}
