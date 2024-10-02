package org.ntut.posd2024f.shapes;

import java.util.List;

public class ConvexPolygon implements Shape {
    private List<TwoDimensionalVector> vectors;

    public ConvexPolygon(List<TwoDimensionalVector> vectors) {
        // if {v1, v2} is ordered by clockwise, the cross product of v1, v2 is negative.
        for (int i = 0; i < vectors.size() - 1; i++) {
            if (vectors.get(i).cross(vectors.get(i + 1)) > 0) {
                throw new ShapeException("");
            }
        }
        this.vectors = vectors;
    }

    public double area() {
        double area = 0;
        for (int i = 0; i < this.vectors.size() - 1; i++) {
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
}