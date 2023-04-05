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
                    .append(System.lineSeparator());
            for (Employee employee : store.findBy(filter)) {
                text.append(employee.getName()).append("; ")
                        .append(dateTimeParser.parse(employee.getHired())).append("; ")
                        .append(dateTimeParser.parse(employee.getFired())).append("; ")
                        .append(employee.getSalary()).append("; ")
                        .append(System.lineSeparator());
            }
            writer.write(text.toString());
            return text.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
