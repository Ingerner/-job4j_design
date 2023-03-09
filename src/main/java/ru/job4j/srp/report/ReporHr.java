package ru.job4j.srp.report;

import ru.job4j.srp.currency.Currency;
import ru.job4j.srp.formatter.DateTimeParser;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.store.MemStore;
import ru.job4j.srp.store.Store;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
/**
 * Отдел HR попросил выводить сотрудников в порядке
 * убывания зарплаты и убрать поля даты найма и увольнения.
 */

public class ReporHr implements Report {

    private final Store store;


    public ReporHr(Store store) {
        this.store = store;
    }

    public static void sort (List<Employee> employees) {
         employees.sort(Comparator.comparing(Employee::getSalary).reversed());
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        List<Employee> list = store.findBy(filter);
        sort(list);
        for (Employee employee : list) {
            text.append(employee.getName()).append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    public static void main(String[] args) {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Max", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        ReporHr hr = new ReporHr(store);
        System.out.println(hr.generate(em-> true));

    }
}

