package com.lesson1;

import com.lesson1.students.Students;
import com.lesson1.films.Films;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);

        Students students = Util.generateStudents(scanner);
        System.out.println(students.toString());

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        Films films = Util.generateFilms(scanner);
        System.out.println(films.toString());

        scanner.close();
    }
}

