package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static java.lang.Math.*;

public class Main {

    
    public static void main(String[] args) {
        int m = new Scanner(System.in).nextInt();
        int n = new Scanner(System.in).nextInt();
        ArrayList<Triangle> triangles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x1 = new Scanner(System.in).nextInt();
            int y1 = new Scanner(System.in).nextInt();
            int x2 = new Scanner(System.in).nextInt();
            int y2 = new Scanner(System.in).nextInt();
            int x3 = new Scanner(System.in).nextInt();
            int y3 = new Scanner(System.in).nextInt();

            triangles.add(new Triangle(x1, y1, x2, y2, x3, y3));
        }

        for (int i = 0; i < m; i++) {
            int x1 = new Scanner(System.in).nextInt();
            int y1 = new Scanner(System.in).nextInt();
            int x2 = new Scanner(System.in).nextInt();
            int y2 = new Scanner(System.in).nextInt();
            int x3 = new Scanner(System.in).nextInt();
            int y3 = new Scanner(System.in).nextInt();

            triangles.add(new RightTriangle(x1, y1, x2, y2, x3, y3));
        }

        double minV = Double.MAX_VALUE;
        double maxV = Double.MIN_VALUE;
        Triangle maxVTriangle = null;
        Triangle minVTriangle = null;

        for (var triangle :
                triangles) {
            triangle.calcEverything();

            if (triangle.getV() < minV) {
                minVTriangle = triangle;
                continue;
            }
            if (triangle.getV() > maxV) {
                maxVTriangle = triangle;
            }

        }


        Set<Triangle> set = new HashSet<>();

        for (int i = 0; i < triangles.size(); i++) {
            if (!set.add(triangles.get(i))) {
                System.out.println(i);
            }
        }


        System.out.println("min triangle: " + minVTriangle);
        System.out.println("max triangle: " + maxVTriangle);
    }


}


class Triangle {
    protected final int x1, y1;
    protected final int x2, y2;
    protected final int x3, y3;
    protected double a;
    protected double b;
    protected double c;
    protected double P;
    protected double V;
    protected double alpha, betta, gamma;


    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.P = 0;
        this.V = 0;
    }

    public double getV() {
        return V;
    }

    public void checkExistence() {
        double _a = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double _b = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        double _c = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));

        System.out.println(_a + _b > _c ? "Triangle exists" : "Triangle doesn't exists");
    }

    public void calcSides() {
        a = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        b = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        c = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
    }

    public void printSides() {
        System.out.printf("a: %f, b: %f, c: %f\n", a, b, c);
    }

    public void calcP() {
        this.P = a + b + c;
    }

    public void printP() {
        System.out.printf("P: %f\n", P);
    }

    public void calcV() {
        this.V = a * b * c;
    }

    public void printV() {
        System.out.printf("V: %f\n", V);
    }

    public void calcDegrees() {
        calcSides();
        alpha = abs(toDegrees(cos((pow(b, 2) + pow(c, 2) - pow(a, 2)) / 2 * b * c)));
        betta = abs(toDegrees(cos((pow(b, 2) + pow(a, 2) - pow(c, 2)) / 2 * b * a)));

        gamma = 180 - (alpha + betta);
    }

    public void printDegrees() {
        System.out.printf("Alpha: %.2f, Betta: %.2f, Gamma: %.2f\n", alpha, betta, gamma);
    }

    public void calcEverything() {
        calcSides();
        calcDegrees();
        calcP();
        calcV();
    }

    public void printEverything() {
        printSides();
        printDegrees();
        printSides();
        printV();
        printP();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                ", x3=" + x3 +
                ", y3=" + y3 +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", P=" + P +
                ", V=" + V +
                ", alpha=" + alpha +
                ", betta=" + betta +
                ", gamma=" + gamma +
                '}';
    }
}

class RightTriangle extends Triangle {

    public RightTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        super(x1, y1, x2, y2, x3, y3);
    }

    public void checkIfRight() {
        calcSides();
        if (pow(a, 2) + pow(b, 2) == pow(c, 2) || pow(c, 2) + pow(b, 2) == pow(a, 2) || pow(c, 2) + pow(a, 2) == pow(b, 2)) {
            System.out.println("triangle is right");
            return;
        }

        System.out.println("triangle is not right");
    }

    @Override
    public double getV() {
        return super.getV();
    }

    @Override
    public void checkExistence() {
        super.checkExistence();
    }

    @Override
    public void calcSides() {
        super.calcSides();
    }

    @Override
    public void printSides() {
        super.printSides();
    }

    @Override
    public void calcP() {
        super.calcP();
    }

    @Override
    public void printP() {
        super.printP();
    }

    @Override
    public void calcV() {
        super.calcV();
    }

    @Override
    public void printV() {
        super.printV();
    }

    @Override
    public void calcDegrees() {
        super.calcDegrees();
    }

    @Override
    public void printDegrees() {
        super.printDegrees();
    }

    @Override
    public void calcEverything() {
        super.calcEverything();
    }

    @Override
    public void printEverything() {
        super.printEverything();
    }

    @Override
    public String toString() {
        return "RightTriangle{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                ", x3=" + x3 +
                ", y3=" + y3 +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", P=" + P +
                ", V=" + V +
                ", alpha=" + alpha +
                ", betta=" + betta +
                ", gamma=" + gamma +
                '}';
    }
}

