package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CircleTest {
    // e.g. Circle c = new Circle(...)
    private Circle c;

    @BeforeEach
    public void Setup() {
        try {
            c = new Circle(3.0);
        }catch (Exception e) {
            fail("Circle creation failed");
        }
    }

    @Test
    public void testException1() throws ShapeException {
        assertThrows(ShapeException.class, () -> new Circle(-3.3), "It's not a circle!");
    }

    @Test
    public void testCirclePerimeter() {
        double ans = Math.PI * 2 * 3.0;
        assertEquals(ans, c.perimeter(), 0.01);
    }

    @Test 
    public void testCircleArea() {
        double ans = Math.PI * 3.0 * 3.0;
        assertEquals(ans, c.area(), 0.01);
    }

    @Test 
    public void testCircleRadius() {
        double ans = 3.0;
        assertEquals(ans, c.getRadius(), 0.01);
    }
}