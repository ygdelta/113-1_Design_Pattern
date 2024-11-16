package org.ntut.posd2024f.shapes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class ShapeBuilder {
    private List<Shape> shapes;
    private Stack<Shape> stack;

    public ShapeBuilder() {
        this.shapes = new ArrayList<>();
        this.stack = new Stack<>();
    }
    
    public void buildCircle(double radius, String color, String text) {
        Shape shape = new Circle(radius);
        if (color != null) {
            shape = new ColoredShape(shape, color);
        }
        if (text != null) {
            shape = new TextedShape(shape, text);
        }
        if (stack.empty()) {
            shapes.add(shape);
        }
        else {
            stack.peek().add(shape);
        }
    }

    public void buildRectangle(double length, double width, String color, String text) {
        Shape shape = new Rectangle(length, width);
        if (color != null) {
            shape = new ColoredShape(shape, color);
        }
        if (text != null) {
            shape = new TextedShape(shape, text);
        }
        if (stack.empty()) {
            shapes.add(shape);
        }
        else {
            stack.peek().add(shape);
        }
    }

    public void buildTriangle(List<TwoDimensionalVector> vectors, String color, String text) {
        Shape shape = new Triangle(vectors);
        if (color != null) {
            shape = new ColoredShape(shape, color);
        }
        if (text != null) {
            shape = new TextedShape(shape, text);
        }
        if (stack.empty()) {
            shapes.add(shape);
        }
        else {
            stack.peek().add(shape);
        }
    }

    public void buildConvexPolygon(List<TwoDimensionalVector> vectors, String color, String text) {
        Shape shape = new ConvexPolygon(vectors);
        if (color != null) {
            shape = new ColoredShape(shape, color);
        }
        if (text != null) {
            shape = new TextedShape(shape, text);
        }
        if (stack.empty()) {
            shapes.add(shape);
        }
        else {
            stack.peek().add(shape);
        }
    }

    public void beginBuildCompoundShape(String color, String text) {
        Shape compound = new CompoundShape(new ArrayList<Shape>());
        if (color != null) {
            compound = new ColoredShape(compound, color);
        }
        if (text != null) {
            compound = new TextedShape(compound, text);
        }
        stack.push(compound);
    }

    public void endBuildCompoundShape() {
        Shape compound = this.stack.pop();
        if (stack.empty()) {
            shapes.add(compound);
        }
        else {
            this.stack.peek().add(compound);
        }
    }

    public List<Shape> getResult() {
        return this.shapes;
    }
}
