package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ShapeTest {
    // e.g. Shape circle = new Circle(...)
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    // @Test
    // public void testTriangle() throws Exception {
    //     Shape t = new Triangle(4, 3, 5);
    //     double perimeter = 4.0 + 3.0 + 5.0;
    //     double s = 0.5 * perimeter;
    //     double area = Math.sqrt(s * (s - 3.0) * (s - 4.0) * (s - 5.0));
    //     assertEquals("Rectangle 4 3 5", t.toString());
    //     assertEquals(perimeter, t.perimeter(), 0.01);
    //     assertEquals(area, t.area(), 0.01);
    // }

    @Test
    public void testCircle() throws Exception {
        Shape c = new Circle(3);
        double perimeter = Math.PI * 2 * 3.0;
        double area = Math.PI * 3.0 * 3.0;
        assertEquals("Circle 3", c.toString());
        assertEquals(perimeter, c.perimeter(), 0.01);
        assertEquals(area, c.area(), 0.01);
    }

    @Test
    public void testRectangle() throws Exception {
        Shape r = new Rectangle(4, 3);
        double perimeter = 2 * (4.0 + 3.0);
        double area = 4.0 * 3.0;
        assertEquals("Rectangle 4 3", r.toString());
        assertEquals(perimeter, r.perimeter(), 0.01);
        assertEquals(area, r.area(), 0.01);
    }
}