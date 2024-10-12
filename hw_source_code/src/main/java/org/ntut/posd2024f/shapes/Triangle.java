package org.ntut.posd2024f.shapes;

import java.util.List;

public class Triangle implements Shape {
    private List<TwoDimensionalVector> vectors;

    public Triangle(List<TwoDimensionalVector> vectors) throws ShapeException {
        int c1 = vectors.get(0).cross(vectors.get(1));
        int c2 = vectors.get(1).cross(vectors.get(2));
        int c3 = vectors.get(2).cross(vectors.get(0));
        if (vectors.size() != 3) { // Triangle must construct by 3 vectors.
            throw new ShapeException("It's not a triangle!");
        }
        if (c1 == 0 && c2 == 0 && c3 == 0) {
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
        TwoDimensionalVector v1 = vectors.get(0).subtract(vectors.get(1));
        TwoDimensionalVector v2 = vectors.get(2).subtract(vectors.get(1));
        return (Math.abs(v1.cross(v2))) / 2.0;
    }

    @Override
    public <T> void accept(Visitor<T> visitor) {
        visitor.visitTriangle(this);
    }

    public List<TwoDimensionalVector> getVectors() {
        return this.vectors;
    }
}
