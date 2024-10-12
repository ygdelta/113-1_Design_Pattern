package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class CompoundShapeTest {
    private CompoundShape test;

    @BeforeEach
    public void SetUp() throws Exception {
        List<Shape> shapes = new ArrayList<>();
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(2, 0));
        vectors.add(new TwoDimensionalVector(-1, 0));
        vectors.add(new TwoDimensionalVector(0, 3));
        Shape s1 = new Circle(1.0);
        Shape s2 = new Triangle(vectors);
        shapes.add(s1);
        shapes.add(s2);
        this.test = new CompoundShape(shapes);
    }

    @Test
    public void testCompoundShapeCreation() throws Exception {
        List<Shape> shapes = new ArrayList<>();
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(2, 0));
        vectors.add(new TwoDimensionalVector(-1, 0));
        vectors.add(new TwoDimensionalVector(0, 3));
        Shape s1 = new Circle(1.0);
        Shape s2 = new Triangle(vectors);
        shapes.add(s1);
        shapes.add(s2);
        new CompoundShape(shapes);
    }

    @Test
    public void testCompoundShapeArea() {
        double ans = (Math.PI * 1.0 * 1.0) + (((2 - (-1)) * 3) / 2.0);
        assertEquals(ans, test.area(), 0.01);
    }

    @Test
    public void testCompoundShapePerimeter() {
        double ans = (Math.PI * 2.0 * 1.0) + (Math.sqrt((3 * 3) + (2 * 2)) + Math.sqrt(1 + (3 * 3)) + 3);
        assertEquals(ans, test.perimeter(), 0.01);
    }

    @Test
    public void testCompoundShapeAdd() throws Exception {
        Shape addShape = new Rectangle(3, 4);
        test.add(addShape);
        double perimeter = (2 * (3 + 4)) + (Math.PI * 2 * 1.0) + (Math.sqrt((3 * 3) + (2 * 2)) + Math.sqrt(1 + (3 * 3)) + 3);
        double area = (3 * 4) + (Math.PI * 1.0 * 1.0) + (((2 - (-1)) * 3) / 2.0);
        assertEquals(area, test.area(), 0.01);
        assertEquals(perimeter, test.perimeter(), 0.01);
    }

}