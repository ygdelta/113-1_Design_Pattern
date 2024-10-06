package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ShapeTest {
    // e.g. Shape circle = new Circle(...)
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testCircle() throws ShapeException {
        Shape c = new Circle(3);
        double perimeter = Math.PI * 2 * 3.0;
        double area = Math.PI * 3.0 * 3.0;
        assertEquals(perimeter, c.perimeter(), 0.01);
        assertEquals(area, c.area(), 0.01);
    }

    @Test
    public void testRectangle() throws ShapeException {
        Shape r = new Rectangle(4, 3);
        double perimeter = 2 * (4.0 + 3.0);
        double area = 4.0 * 3.0;
        assertEquals(perimeter, r.perimeter(), 0.01);
        assertEquals(area, r.area(), 0.01);
    }
}