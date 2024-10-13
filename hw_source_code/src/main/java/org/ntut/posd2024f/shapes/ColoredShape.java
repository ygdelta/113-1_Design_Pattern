package org.ntut.posd2024f.shapes;

import java.util.Iterator;

public class ColoredShape implements Shape {
    private Shape shape;
    private String color;
    public ColoredShape(Shape shape, String color) {
        if (color != "RED" && color != "Green" && color != "BLUE") {
            throw new ShapeException("Color is not defined.");
        }
        this.shape = shape;
        this.color = color;
    }

    @Override
    public double area() {
        return shape.area();
    }

    @Override
    public double perimeter() {
        return shape.perimeter();
    }

    // @Override
    // public void add(Shape shape) {
    // }

    // @Override
    // public Iterator<Shape> iterator() {
    // }

    public Shape getShape() {
        return this.shape;
    }

    public String getColor() {
        return this.color;
    }

    @Override
    public <T> void accept(Visitor<T> visitor) {
        visitor.visitColoredShape(this);
        this.shape.accept(visitor);
    }
}
