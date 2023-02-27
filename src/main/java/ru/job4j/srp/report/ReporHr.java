package ru.job4j.srp.report;

import ru.job4j.srp.formatter.DateTimeParser;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.store.Store;

import java.util.Calendar;
import java.util.Comparator;
import java.util.function.Predicate;
/**
 * Отдел HR попросил выводить сотрудников в порядке
 * убывания зарплаты и убрать поля даты найма и увольнения.
 */

public class ReporHr implements Report, Comparator<Employee> {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public ReporHr(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {

        return null;
    }
}

public class SortBySalaryEmployee implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getSalary().;
    }
}