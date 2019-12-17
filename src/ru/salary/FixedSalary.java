package ru.salary;

public class FixedSalary extends AbstractSalary {

    @Override
    protected String salaryCalculation() {
        return String.valueOf(AbstractSalary.getFixedPayment() * AbstractSalary.getTAX());
    }
}
