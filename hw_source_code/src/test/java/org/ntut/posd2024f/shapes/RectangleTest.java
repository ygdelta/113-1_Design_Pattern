package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RectangleTest {
    // e.g. Rectangle r = new rectangle(...)    
    private Rectangle r;

    @BeforeEach
    public void Setup() {
        try {
            r = new Rectangle(4, 3);
        }catch (Exception e) {
            fail("Rectangle creation failed");
        }
    }

    @Test // TODO:
    public void testTriangleCreationFailure() throws ShapeException {
        assertThrows(ShapeException.class, () -> new Rectangle(-3.3, 3), "It's not a rectangle!");
    }

    @Test
    public void testRectanglePerimeter() {
        double ans = 2 * (4.0 + 3.0);
        assertEquals(ans, r.perimeter(), 0.01);
    }

    @Test
    public void testRectangleArea() {
        double ans = 4.0 * 3.0;
        assertEquals(ans, r.area(), 0.01);
    }

}