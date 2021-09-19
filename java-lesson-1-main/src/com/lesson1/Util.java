package com.lesson1;

import com.lesson1.students.Student;
import com.lesson1.students.Students;
import com.lesson1.workers.Worker;
import com.lesson1.workers.Workers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Util {
    public static Students generateStudents(Scanner scanner) throws Exception {
        System.out.print("Pass the amount of students: ");
        final int N = scanner.nextInt();
        scanner.nextLine();

        Students students = new Students();

        for (int i = 0; i < N; i++) {
            Student simpleStudent = new Student();

            System.out.println("\n====== Student #" + (i + 1) + " ======");

            // Surname
            System.out.print("Enter the surname: ");
            simpleStudent.setSurname(scanner.nextLine());

            // Speciality
            int speciality;
            do {
                System.out.print("Enter the speciality (numbers): ");

                while (!scanner.hasNextInt()) {
                    System.err.print("Enter the speciality (numbers): ");
                    scanner.next();
                }

                speciality = scanner.nextInt();
                simpleStudent.setSpeciality(speciality);
            } while (speciality <= 0);
            
            // year of admission
            int yearOfAdmission;
            do {
                System.out.print("Enter the Year of Admission: ");

                while (!scanner.hasNextInt()) {
                    System.err.print("Enter the Year of Admission: ");
                    scanner.next();
                }

                yearOfAdmission = scanner.nextInt();
                simpleStudent.setYearOfAdmission(yearOfAdmission);
            } while (yearOfAdmission <= 2014 || yearOfAdmission >= 2021);
            
            // MathGrade
            int mathGrade;
            do {
                System.out.print("Enter the Math Grade: ");

                while (!scanner.hasNextInt()) {
                    System.err.print("Enter the Math Grade: ");
                    scanner.next();
                }

                mathGrade = scanner.nextInt();
                simpleStudent.setMathGrade(mathGrade);
            } while (mathGrade <= 0);

            // physicsGrade
            int physicsGrade;
            do {
                System.out.print("Enter the Physics Grade: ");

                while (!scanner.hasNextInt()) {
                    System.err.print("Enter the Physics Grade: ");
                    scanner.next();
                }

                physicsGrade = scanner.nextInt();
                simpleStudent.setPhysicsGrade(physicsGrade);
            } while (physicsGrade <= 0);

            // informGrade
            int informGrade;
            do {
                System.out.print("Enter the Inform Grade: ");

                while (!scanner.hasNextInt()) {
                    System.err.print("Enter the Inform Grade: ");
                    scanner.next();
                }

                informGrade = scanner.nextInt();
                simpleStudent.setInformGrade(informGrade);
            } while (informGrade <= 0);

            scanner.nextLine();

            students.addStudent(simpleStudent);
        }

        return students;
    }

    public static Workers generateWorkers(Scanner scanner) {
        System.out.print("Pass the amount of films: ");
        final int N = scanner.nextInt();
        scanner.nextLine();

        Workers films = new Workers();

        for (int i = 0; i < N; i++) {
            Worker simpleFilm = new Worker();

            System.out.println("\n====== FILM #" + (i + 1) + " ======");

            System.out.print("Enter the title of film: ");
            simpleFilm.setTitle(scanner.nextLine());

            // Date of creation
            while (true) {
                System.out.print("Enter the date and time (dd/MM/yyyy date format && hh:mm time format): ");
                String scannedDate = scanner.nextLine();

                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    LocalDateTime sessionTime = LocalDateTime.parse(scannedDate, formatter);

                    simpleFilm.setSessionDate(sessionTime);
                    break;
                } catch (Exception ignored) {
                }
            }

            // Duration
            double duration;
            do {
                System.out.print("Enter the duration: ");

                while (!scanner.hasNextDouble()) {
                    System.err.print("Enter the duration: ");
                    scanner.next();
                }

                duration = scanner.nextDouble();
                simpleFilm.setTimeDuration(duration);
            } while (duration <= 0);


            // Genre
            scanner.nextLine();
            System.out.print("Enter the genre: ");
            simpleFilm.setGenre(scanner.nextLine());

            // Budget
            System.out.print("Enter the budget: ");
            simpleFilm.setBudget(scanner.nextDouble());
            scanner.nextLine();

            films.addWorker(simpleFilm);
        }

        return films;
    }

    public static boolean checkTime(String time) {
        String RegEx = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$";

        return time.matches(RegEx);
    }

    public static boolean checkDate(String date) {
        String RegExp = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";

        return date.matches(RegExp);
    }

}
