package ru.job4j.srp;

/*  * Автопарк.
 * Нарушение правил SRP каждый класс должен иметь обну ответственность.
 *  Данном случаи класс имеет несколько ответственносте, и и более одной присины для изменения.
 */

/* @author OlegKorotkiy
 * @version 1.0
 * @since 18.01.2023
 */

public class CarPark {
    private String carName;
    private int yearIssue;
    private String driverName;

    public CarPark(String carName, int yearIssue, String driverName) {
        this.carName = carName;
        this.yearIssue = yearIssue;
        this.driverName = driverName;
    }

    public String getCarName() {
        return carName;
    }

    public int getYearIssue() {
        return yearIssue;
    }

    public String getDriverName() {
        return driverName;
    }

    void carsOnRoute() {

    }
}
