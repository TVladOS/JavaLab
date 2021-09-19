package com.lesson1;

import com.lesson1.students.Students;
import com.lesson1.workers.Workers;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);

        Students students = Util.generateStudents(scanner);
        System.out.println(students.toString());

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        Workers workers = Util.generateWorkers(scanner);
        System.out.println(workers.toString());

        scanner.close();
    }
}

