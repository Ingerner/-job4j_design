package ru.job4j.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.srp.currency.Currency;
import ru.job4j.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.srp.formatter.DateTimeParser;
import ru.job4j.srp.formatter.ReportDateTimeParser;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.store.MemStore;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.*;

public class ReportAccountingTest {

    @Test
    public void whenTheReportForAccountantsWasGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        InMemoryCurrencyConverter conv = new InMemoryCurrencyConverter();
        store.add(worker);
        Report engine = new ReportAccounting(store, parser, conv);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(parser.parse(worker.getHired())).append(" ")
                .append(parser.parse(worker.getFired())).append(" ")
                .append(conv.convert(Currency.USD, worker.getSalary(), Currency.RUB))
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }

}