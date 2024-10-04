package org.ntut.posd2024f.shapes;

import java.util.ArrayList;
import java.util.List;

public class ConvexPolygon implements Shape {
    private List<TwoDimensionalVector> vectors;

    public ConvexPolygon(List<TwoDimensionalVector> vectors) {
        if (!isOrdered(vectors)) {
            throw new ShapeException("It's not a convex polygon!");
        }
        this.vectors = vectors;
    }

    public double area() {
        double area = 0;
        for (int i = 1; i < this.vectors.size() - 1; i++) {
            area += Math.abs(this.vectors.get(i).cross(this.vectors.get(i + 1)));
        }
        area += Math.abs(this.vectors.get(vectors.size() - 1).cross(this.vectors.get(0)));
        return area / 2.0;
    }

    public double perimeter() {
        double perimeter = 0;
        for (int i = 0; i < this.vectors.size() - 1; i++) {
            perimeter += this.vectors.get(i).subtract(this.vectors.get(i + 1)).length();
        }
        perimeter += this.vectors.get(vectors.size() - 1).subtract(this.vectors.get(0)).length();
        return perimeter;
    }

    private boolean isOrdered(List<TwoDimensionalVector> vectors) {
        List<TwoDimensionalVector> sides = new ArrayList<>();
        TwoDimensionalVector test = vectors.get(0).subtract(vectors.get(vectors.size() - 1));
        sides.add(test);
        for (int i = 0; i < vectors.size() - 1; i++) {
            TwoDimensionalVector diff = vectors.get(i + 1).subtract(vectors.get(i));
            test = test.add(diff);
            sides.add(test);
        }
        return clockWise(sides) || counterClockWise(sides);
    }
    
    private boolean clockWise(List<TwoDimensionalVector> vectors) {
        for (int i = 0; i < vectors.size() - 2; i++) {
            int c1 = vectors.get(i).cross(vectors.get(i + 1));
            int c2 = vectors.get(i + 1).cross(vectors.get(i + 2));
            int c3 = vectors.get(i).cross(vectors.get(i + 2));
            if (c1 > 0 || c2 > 0 || c3 > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean counterClockWise(List<TwoDimensionalVector> vectors) {
        for (int i = 0; i < vectors.size() - 2; i++) {
            int c1 = vectors.get(i).cross(vectors.get(i + 1));
            int c2 = vectors.get(i + 1).cross(vectors.get(i + 2));
            int c3 = vectors.get(i).cross(vectors.get(i + 2));
            if (c1 < 0 || c2 < 0 || c3 < 0) {
                return false;
            }
        }
        return true;
    }
}