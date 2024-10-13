package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FindShapeVisitorTest {
    private FindShapeVisitor visitor;

    @BeforeEach
    public void SetUp() {
        Predicate<Shape> condition = s -> s.area() > 6;
        visitor = new FindShapeVisitor(condition);
    }

    @Test
    public void FindShapeVisitorCircle() {
        Shape c1 = new Circle(5.0);
        Shape c2 = new Circle(1.0);
        Shape c3 = new Circle(2.0);
        List<Shape> arr = new ArrayList<>();
        arr.add(c1); arr.add(c2); arr.add(c3);
        for (Shape c: arr) {
            c.accept(visitor);
        }
        assertEquals(2, visitor.getResult().size());
    }

    @Test
    public void FindShapeVisitorTriangle() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(3, 0));
        vectors.add(new TwoDimensionalVector(0, 4));
        Shape t1 = new Triangle(vectors);
        t1.accept(visitor);
        assertEquals(0, visitor.getResult().size());
    }

    @Test
    public void FindShapeVisitorRectangle() {
        Shape r1 = new Rectangle(5.0, 3.0);
        Shape r2 = new Rectangle(1.0, 2.0);
        Shape r3 = new Rectangle(2.0, 4.0);
        List<Shape> arr = new ArrayList<>();
        arr.add(r1); arr.add(r2); arr.add(r3);
        for (Shape c: arr) {
            c.accept(visitor);
        }
        assertEquals(2, visitor.getResult().size());
    }

    @Test
    public void FindShapeVisitorConvexPolygon() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(3, 0));
        vectors.add(new TwoDimensionalVector(3, 4));
        Shape convex1 = new ConvexPolygon(vectors);
        vectors.add(new TwoDimensionalVector(0, 4));
        System.out.println(vectors);
        Shape convex2 = new ConvexPolygon(vectors);
        List<Shape> arr = new ArrayList<>();
        arr.add(convex1); arr.add(convex2);
        for (Shape s: arr) { s.accept(visitor); }
        assertEquals(2, visitor.getResult().size());
    }

    @Test
    public void FindShapeVisitorCompoundShape() {
        Shape c1 = new Circle(5.0);
        Shape r1 = new Rectangle(5.0, 3.0);
        Shape c2 = new Circle(1.0);
        List<Shape> comList = new ArrayList<>();
        comList.add(r1); comList.add(c2);
        Shape compound = new CompoundShape(comList);
        List<Shape> arr = new ArrayList<>();
        arr.add(c1); arr.add(r1); arr.add(c2); arr.add(compound);
        for (Shape s: arr) {
            s.accept(visitor);
        }
        assertEquals(4, visitor.getResult().size());
    }

    @Test
    public void FindShapeVisitorTextedShape() {
        Shape c1 = new Circle(5.0);
        String text = "this is a text.";
        Shape shape = new TextedShape(c1, text);
        List<Shape> arr = new ArrayList<>();
        arr.add(c1); arr.add(shape);
        for (Shape s: arr) {
            s.accept(visitor);
        }
        assertEquals(3, visitor.getResult().size());
    }

    @Test
    public void FindShapeVisitorColoredShape() {
        Shape c1 = new Circle(5.0);
        String color = "RED";
        Shape shape = new ColoredShape(c1, color);
        List<Shape> arr = new ArrayList<>();
        arr.add(c1); arr.add(shape);
        for (Shape s: arr) {
            s.accept(visitor);
        }
        assertEquals(3, visitor.getResult().size());
    }
}
