package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
    int age = 30;
    long money = 900000;
    short size = 1;
    float length = 1.05F;
    char exit = 'E';
    byte log = 4;
    double dbl = 100500.99;
    boolean flag = true;
    LOG.debug("Вывод переменных : {}, age : {}, money : {}, size : {}, " +
                    "Length : {}, exit : {}, log : {}, dbl : {}, flag",
            age, money, size,length, exit, log, dbl, flag);
    }
}