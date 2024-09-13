package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CircleTest {
    // e.g. Circle c = new Circle(...)
    @Test(expected = Exception.class)
    public void testException1() throws Exception {
        Circle c = new Circle(-3.3);
    }

    public void testCircle() throws Exception {
        Circle c = new Circle(3);
        assertEquals("Circle 3", c.toString());
    }
}