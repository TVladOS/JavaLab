package com.lesson1.students;

import java.util.ArrayList;

public class Students {
    private final ArrayList<Student> students = new ArrayList<Student>();

    public void addStudent(Student student) {
        if (student != null) {
            this.students.add(student);
        } else {
            System.err.print("Provided element is not a student!");
        }
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    @Override
    public String toString() {
        StringBuilder answer = new StringBuilder();
        for (Student student : students) {
            if (student.getYearOfAdmission() <= 2019) {
                answer.append(String.format("\n\n[RESULT]\nSurname: %s\nSpeciality: %d\nPhysics Grade: %d\nMath Grade: %d\nInform Grade: %d\nYear of admission: %s\n", student.getSurname(), student.getSpeciality(), student.getPhysicsGrade(), student.getMathGrade(), student.getInformGrade(), student.getYearOfAdmission()));
            }
        }
        return answer.toString();
    }
}
