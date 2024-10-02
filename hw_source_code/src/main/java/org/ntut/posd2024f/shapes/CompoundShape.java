package org.ntut.posd2024f.shapes;

import java.util.Iterator;
import java.util.List;

public class CompoundShape implements Shape {
    private List<Shape> shapes;

    public CompoundShape(List<Shape> shapes) {
        this.shapes = shapes;
    }
    
    public double area() {
        double area = 0;
        for (int i = 0; i < shapes.size(); i++) {
            area += shapes.get(i).area();
        }
        return area;
    }
 
    public double perimeter() {
        double perimeter = 0;
        for (int i = 0; i < shapes.size(); i++) {
            perimeter += shapes.get(i).perimeter();
        }
        return perimeter;
    }
 
    @Override
    public void add(Shape shape) {
        shapes.add(shape);
    }
 
    @Override
    public Iterator<Shape> iterator() {
        return shapes.iterator();
    }
}