package com.lesson1.workers;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

/*
Средний уровень: создать класс с нижеуказанными полями и вывести данные о фильмах, начинающихся после 18:00 ипродолжительностью сеанса более 1 часа и 40 минут
    Наименование
    Дата и время сеанса
    Продолжительность сеанса
    Жанр
    Бюджет
*/

public class Worker {
    private String surname;
    private LocalDateTime signingDate;
    private double timeValidity;
    private String position;
    private double salary;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDateTime getSigningDate() {
        return this.signingDate;
    }

    public void setSigningDate(LocalDateTime signingDate) {
        this.signingDate = signingDate;
    }

    public double getTimeValidity() {
        return timeValidity;
    }

    public void setTimeDuration(double timeDuration) {
        DecimalFormat df = new DecimalFormat("#0.0");
        String s = df.format(timeDuration);
        this.timeValidity = s.contains(".6") ? Math.ceil(timeDuration) : timeDuration;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = (int) salary;
    }
}
