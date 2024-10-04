package org.ntut.posd2024f.shapes;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TriangleTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testTriangleException1() {
        thrown.expect(ShapeException.class);
        thrown.expectMessage("It's not a triangle!");
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(2, 0));
        vectors.add(new TwoDimensionalVector(-1, 0));
        vectors.add(new TwoDimensionalVector(0, 0));
        new Triangle(vectors);
    }

    @Test
    public void testTriangleException2() {
        thrown.expect(ShapeException.class);
        thrown.expectMessage("It's not a triangle!");
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(1, 0));
        vectors.add(new TwoDimensionalVector(0, 0));
        new Triangle(vectors);
    }

    @Test
    public void testTriangleCreation1() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(2, 0));
        vectors.add(new TwoDimensionalVector(-1, 0));
        vectors.add(new TwoDimensionalVector(0, 3));
        new Triangle(vectors);
    }

    @Test
    public void testTriangleCreation2() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(1, 3));
        vectors.add(new TwoDimensionalVector(2, -1));
        vectors.add(new TwoDimensionalVector(0, 0));
        new Triangle(vectors);
    }

    @Test
    public void testTrianglePerimeter() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(2, 0));
        vectors.add(new TwoDimensionalVector(-1, 0));
        vectors.add(new TwoDimensionalVector(0, 3));
        Triangle t = new Triangle(vectors);
        double ans = Math.sqrt((3 * 3) + (2 * 2)) + Math.sqrt(1 + (3 * 3)) + 3;
        assertEquals(ans, t.perimeter(), 0.01);
    }

    @Test
    public void testTriangleArea() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(2, 0));
        vectors.add(new TwoDimensionalVector(-1, 0));
        vectors.add(new TwoDimensionalVector(0, 3));
        Triangle t = new Triangle(vectors);
        double ans = ((2 - (-1)) * 3) / 2.0; // 1/2 * w * h
        assertEquals(ans, t.area(), 0.01);
    }
}