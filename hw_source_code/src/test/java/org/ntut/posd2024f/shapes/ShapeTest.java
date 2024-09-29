package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ShapeTest {
    // e.g. Shape circle = new Circle(...)
    @Test(expected = Exception.class)
    public void testException1() throws Exception {
        Shape r = new Rectangle(-3.3, 3);
    }

    @Test(expected = Exception.class)
    public void testException2() throws Exception {
        Shape c = new Circle(-3.3);
    }

    @Test(expected = Exception.class)
    public void testException3() throws Exception {
        Triangle t = new Triangle(10, 3, 4);
    }

    @Test(expected = Exception.class)
    public void testException4() throws Exception {
        Rectangle r = new Rectangle(-3.3, 3);
    }

    @Test
    public void testTriangleToString() throws Exception {
        Shape r = new Rectangle(4, 3);
        assertEquals("Rectangle 4 3", r.toString());
    }

    @Test
    public void testTrianglePerimeter() {

    }

    @Test
    public void testCircleToString() throws Exception {
        Shape c = new Circle(3);
        assertEquals("Circle 3", c.toString());
    }

    @Test
    public void testRectangleToString() throws Exception {
        Rectangle r = new Rectangle(4, 3);
        assertEquals("Rectangle 4 3", r.toString());
    }
}