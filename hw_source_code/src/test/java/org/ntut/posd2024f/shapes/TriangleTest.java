package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TriangleTest {
    // Triangle t = new Triangle(...)
    private Triangle t;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void Setup() {
        try {
            t = new Triangle(5, 3, 4);
        }catch (Exception e) {
            fail("Triangle creation failed");
        }
    }

    @Test
    public void testException1() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("It's not a triangle!");
        new Triangle(-1.0, 3, 4);
    }

    @Test
    public void testException2() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("It's not a triangle!");
        new Triangle(10, 3, 4);
    }

    @Test
    public void testTriangleToString() throws Exception {
        assertEquals("Triangle 3 4 5", t.toString());
    }

    @Test
    public void testTrianglePerimeter() {
        double ans = 3.0 + 4.0 + 5.0;
        assertEquals(ans, t.perimeter(), 0.01);
    }

    @Test
    public void testTriangleArea() {
        double s = 0.5 * (3.0 + 4.0 + 5.0);
        double ans = Math.sqrt(s * (s - 3.0) * (s - 4.0) * (s - 5.0));
        assertEquals(ans, t.area(), 0.01);
    }
}