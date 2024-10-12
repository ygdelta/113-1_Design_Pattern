package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FindShapeVisitorTest {
    private FindShapeVisitor vistor;

    @BeforeEach
    public void SetUp() {
        Predicate<Shape> condition = s -> s.area() > 6;
        vistor = new FindShapeVisitor(condition);
    }

    @Test
    public void FindShapeVisitorCircle() {
        Shape c1 = new Circle(5.0);
        Shape c2 = new Circle(1.0);
        Shape c3 = new Circle(2.0);
        List<Shape> arr = new ArrayList<>();
        arr.add(c1); arr.add(c2); arr.add(c3);
        for (Shape c: arr) {
            c.accept(vistor);
        }
        assertEquals(2, vistor.getResult().size());
    }

    @Test
    public void FindShapeVisitorTriangle() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(3, 0));
        vectors.add(new TwoDimensionalVector(0, 4));
        Shape t1 = new Triangle(vectors);
        t1.accept(vistor);
        assertEquals(0, vistor.getResult().size());
    }

    @Test
    public void FindShapeVisitorRectangle() {
        Shape r1 = new Rectangle(5.0, 3.0);
        Shape r2 = new Rectangle(1.0, 2.0);
        Shape r3 = new Rectangle(2.0, 4.0);
        List<Shape> arr = new ArrayList<>();
        arr.add(r1); arr.add(r2); arr.add(r3);
        for (Shape c: arr) {
            c.accept(vistor);
        }
        assertEquals(2, vistor.getResult().size());
    }
}
