package ru.job4j.srp.store;

import ru.job4j.srp.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public interface Store {
    void add(Employee em);

    List<Employee> findBy(Predicate<Employee> filter);

    void sort(ArrayList<Employee> employees);
}
