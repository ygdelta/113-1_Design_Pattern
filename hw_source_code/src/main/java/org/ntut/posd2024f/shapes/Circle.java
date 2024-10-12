package org.ntut.posd2024f.shapes;

public class Circle implements Shape {
    private double radius;
    public Circle(double radius) throws ShapeException {
        if (radius <= 0) {
            throw new ShapeException("It's not a circle!");
        }
        this.radius = radius;
    }

    public double area() {
        return this.radius * this.radius * Math.PI;
    } 

    public double perimeter() {
        return this.radius * 2 * Math.PI;
    }

    public String toString() {
        return new String("Circle " + Double.valueOf(this.radius));
    }

    @Override
    public <T> void accept(Visitor<T> vistor) {
        vistor.visitCircle(this);
    }

    public double getRadius() {
        return this.radius;
    }
}
