package org.ntut.posd2024f.shapes;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

public class Triangle implements Shape
{
    private double a, b, c;
    Triangle(double a, double b, double c) throws Exception {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new Exception("It's not a triangle!");
        }
        if (a + b <= c || b + c <= a || c + a <= b) {
            throw new Exception("It's not a triangle!");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double perimeter() {
        return this.a + this.b + this.c;
    }

    public double area() {
        double s = this.perimeter() / 2;
        return Math.sqrt(s * (s - this.a) * (s - this.b) * (s - this.c));
    }

    public String toString() {
        String a = this.a % 1 == 0 ? String.format("%.0f", this.a) : String.format("%.1f", this.a);
        String b = this.b % 1 == 0 ? String.format("%.0f", this.b) : String.format("%.1f", this.b);
        String c = this.c % 1 == 0 ? String.format("%.0f", this.c) : String.format("%.1f", this.c);
        return new String("Triangle " + Double.valueOf(a) + " " + Double.valueOf(b) + " " + Double.valueOf(c));
    }
}
