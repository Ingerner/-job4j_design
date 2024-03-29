package ru.job4j.srp.report;

import ru.job4j.srp.currency.Currency;
import ru.job4j.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.srp.formatter.DateTimeParser;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.store.Store;


import java.util.Calendar;
import java.util.function.Predicate;

public class ReportAccounting implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private final InMemoryCurrencyConverter currencyConverter;

    public ReportAccounting(Store store, DateTimeParser<Calendar> dateTimeParser,
                            InMemoryCurrencyConverter currencyConverter) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.currencyConverter = currencyConverter;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            employee.setSalary(currencyConverter.convert(Currency.USD, employee.getSalary(), Currency.RUB));
            text.append(employee.getName()).append(" ")
                    .append(dateTimeParser.parse(employee.getHired())).append(" ")
                    .append(dateTimeParser.parse(employee.getFired())).append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
