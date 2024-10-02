package org.ntut.posd2024f.shapes;

import java.util.List;

public class Triangle implements Shape {
    private TwoDimensionalVector v1;
    private TwoDimensionalVector v2;
    private TwoDimensionalVector v3;

    public Triangle(List<TwoDimensionalVector> vectors) throws Exception {
        if (vectors.size() != 3) { // Triangle must construct by 2 vectors.
            throw new Exception("It's not a triangle!");
        }
        TwoDimensionalVector v1 = vectors.get(0);
        TwoDimensionalVector v2 = vectors.get(1);
        TwoDimensionalVector v3 = vectors.get(2);
        int v1_x = v1.getX();
        int v2_x = v2.getX();
        int v3_x = v3.getX();
        int v1_y = v1.getY();
        int v2_y = v2.getY();
        int v3_y = v3.getY();
        if ((v1_x == 0 && v1_y == 0) || (v2_x == 0 && v2_y == 0) || (v3_x == 0 && v3_y == 0)) { // vector cannot be 0 vector.
            throw new Exception("It's not a triangle");
        }
        if ((v1_x / v2_x == v1_y / v2_y) || (v1_x / v3_x == v1_y / v3_y) || (v2_x / v3_x == v2_y / v2_y)) { // vectors cannot be parallel.
            throw new Exception("It's not a triangle!");
        }
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public double perimeter() {
        double a = this.v1.subtract(v2).length();
        double b = this.v2.subtract(v3).length();
        double c = this.v3.subtract(v1).length();
        return a + b + c;
    }

    public double area() {
        int a = this.v1.cross(v2);
        int b = this.v2.cross(v3);
        int c = this.v3.cross(v1);
        return a + b + c;
    }
}
