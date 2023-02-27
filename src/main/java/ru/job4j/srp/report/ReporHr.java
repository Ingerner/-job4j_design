package ru.job4j.srp.report;

import ru.job4j.srp.currency.Currency;
import ru.job4j.srp.formatter.DateTimeParser;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.store.Store;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.function.Predicate;
/**
 * Отдел HR попросил выводить сотрудников в порядке
 * убывания зарплаты и убрать поля даты найма и увольнения.
 */

public class ReporHr implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public ReporHr(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    public static void sort (ArrayList<Employee> employees) {
        employees.sort(Comparator.comparing(Employee::getSalary).reversed());
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
