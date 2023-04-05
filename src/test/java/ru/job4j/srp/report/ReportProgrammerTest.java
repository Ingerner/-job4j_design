package ru.job4j.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.srp.formatter.DateTimeParser;
import ru.job4j.srp.formatter.ReportDateTimeParser;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.store.MemStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportProgrammerTest {
    @Test
    public void  whenTheReportForAccountantsWasProgrammers() {
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
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker1.getName()).append("; ")
                .append(parser.parse(worker1.getHired())).append("; ")
                .append(parser.parse(worker1.getFired())).append("; ")
                .append(worker1.getSalary()).append("; ")
                .append(System.lineSeparator())
                .append(worker2.getName()).append("; ")
                .append(parser.parse(worker2.getHired())).append("; ")
                .append(parser.parse(worker2.getFired())).append("; ")
                .append(worker2.getSalary()).append("; ")
                .append(System.lineSeparator())
                .append(worker3.getName()).append("; ")
                .append(parser.parse(worker3.getHired())).append("; ")
                .append(parser.parse(worker3.getFired())).append("; ")
                .append(worker3.getSalary()).append("; ")
                .append(System.lineSeparator());


        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());

    }

}