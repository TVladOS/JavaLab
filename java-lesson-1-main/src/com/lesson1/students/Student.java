package com.lesson1.students;

/*
Базовый уровень: создать класс с нижеуказанными полями и определить количество студентов, учащихся на 3 курсе и старше 
и напечатать все сведения о них.
- Фамилия
- Специальность
- Год поступления
- Оценка по физике
- Оценка по математике
- Оценка по информатике
*/

public class Student {
    private String surname;
    private int speciality;
    private int yearOfAdmission;
    private int physicsGrade;
    private int mathGrade;
    private int informGrade;
    

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSpeciality() {
        return this.speciality;
    }

    public void setSpeciality(int speciality) {
        this.speciality = speciality;
    }

    public int getPhysicsGrade() {
        return this.physicsGrade;
    }

    public void setPhysicsGrade(int physicsGrade) {
        this.physicsGrade = physicsGrade;
    }
    
    public int getMathGrade() {
        return this.mathGrade;
    }

    public void setMathGrade(int mathGrade) {
        this.mathGrade = mathGrade;
    }
    
    public int getInformGrade() {
        return this.informGrade;
    }

    public void setInformGrade(int informGrade) {
        this.informGrade = informGrade;
    }
    
    public int getYearOfAdmission() {
        return this.yearOfAdmission;
    }

    public void setYearOfAdmission(int yearOfAdmission) {
        this.yearOfAdmission = yearOfAdmission;
    }

}
