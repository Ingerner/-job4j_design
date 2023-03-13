package ru.job4j.srp.report;

import ru.job4j.srp.formatter.DateTimeParser;
import ru.job4j.srp.formatter.ReportDateTimeParser;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.store.MemStore;
import ru.job4j.srp.store.Store;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.function.Predicate;

public class ReportProgrammer implements Report {

    private final ru.job4j.srp.store.Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public ReportProgrammer(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        try (PrintWriter writer = new PrintWriter(new File("test.csv"))) {
            StringBuilder text = new StringBuilder();
            text.append("Name; Hired; Fired; Salary;")
                    .append(System.lineSeparator());;
            writer.write(text.toString());
            for (Employee employee : store.findBy(filter)) {
                text.append(employee.getName()).append(" ")
                        .append(dateTimeParser.parse(employee.getHired())).append(" ")
                        .append(dateTimeParser.parse(employee.getFired())).append(" ")
                        .append(employee.getSalary())
                        .append(System.lineSeparator());
            }
            writer.write(text.toString());
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Oleg", now, now, 200);
        Employee worker3 = new Employee("Sergey", now, now, 300);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new ReportProgrammer(store, parser);
        engine.generate(em -> true);
    }
}
