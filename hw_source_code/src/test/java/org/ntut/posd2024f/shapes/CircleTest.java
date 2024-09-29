package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CircleTest {
    // e.g. Circle c = new Circle(...)
    private Circle c;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void Setup() {
        try {
            c = new Circle(3.0);
        }catch (Exception e) {
            fail("Circle creation failed");
        }
    }

    @Test
    public void testException1() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("It's not a circle!");
        new Circle(-3.3);
    }

    @Test
    public void testCircleToString() throws Exception {
        assertEquals("Circle 3", c.toString());
    }

    @Test
    public void testCirclePerimeter() {
        double ans = Math.PI * 2 * 3.0;
        assertEquals(ans, c.perimeter(), 0.01);
    }

    @Test void testCircleArea() {
        double ans = Math.PI * 3.0 * 3.0;
        assertEquals(ans, c.area(), 0.01);
    }
}