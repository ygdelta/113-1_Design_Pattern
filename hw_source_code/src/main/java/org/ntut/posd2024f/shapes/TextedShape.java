package org.ntut.posd2024f.shapes;

import java.util.Iterator;

public class TextedShape implements Shape {
    private Shape shape;
    private String text;
    public TextedShape(Shape shape, String text) {
        this.shape = shape;
        this.text = text;
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

    public String getText() {
        return this.text;
    }

    // @Override
    // public <T> void accept(Visitor<T> visitor) {
    // }
}
