package org.ntut.posd2024f.shapes;

import java.util.List;

public class Triangle implements Shape {
    private List<TwoDimensionalVector> vectors;

    public Triangle(List<TwoDimensionalVector> vectors) throws ShapeException {
        if (vectors.size() != 3) { // Triangle must construct by 3 vectors.
            throw new ShapeException("It's not a triangle!");
        }
        if (!checkValidZeroVector(vectors)) {
            throw new ShapeException("It's not a triangle!");
        }
        if (! checkValidDirection(vectors)) {
            throw new ShapeException("It's not a triangle!");
        }
        this.vectors = vectors;
    }

    public double perimeter() {
        double a = this.vectors.get(0).subtract(vectors.get(1)).length();
        double b = this.vectors.get(1).subtract(vectors.get(2)).length();
        double c = this.vectors.get(2).subtract(vectors.get(0)).length();
        return a + b + c;
    }

    public double area() {
        int a = this.vectors.get(0).cross(vectors.get(1));
        int b = this.vectors.get(1).cross(vectors.get(2));
        int c = this.vectors.get(2).cross(vectors.get(0));
        return (Math.abs(a) + Math.abs(b) + Math.abs(c)) / 2.0;
    }

    private boolean checkValidZeroVector(List<TwoDimensionalVector> vectors) {
        int[] arrZero = new int[3];
        int sum = 0;
        for (int i = 0; i < vectors.size(); i++) {
            if (vectors.get(i).isZero()) {
                arrZero[i] = 1;
            }else {
                arrZero[i] = 0;
            }
        }
        for (int i = 0; i < vectors.size(); i++) {
            sum += arrZero[i];
        }
        if (sum == 2 || sum == 3) {
            return false;
        }
        return true;
    }

    private boolean checkValidDirection(List<TwoDimensionalVector> vectors) {
        for (int i = 0; i < vectors.size(); i++) {
            if (vectors.get(i).isZero()) {
                vectors.remove(i);
            }
        }
        if (vectors.size() == 3) {
            return true;
        }
        if (vectors.get(0).isParallel(vectors.get(1))) {
            return false;
        }
        return true;
    }
}
