package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RectangleTest {
    // e.g. Rectangle r = new rectangle(...)    
    private Rectangle r;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void Setup() {
        try {
            r = new Rectangle(4, 3);
        }catch (Exception e) {
            fail("Rectangle creation failed");
        }
    }

    @Test
    public void testTriangleCreationFailure() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("It's not a rectangle!");
        new Rectangle(-3.3, 3);
    }

    // @Test
    // public void testRectangleToString() throws Exception {
    //     assertEquals("Rectangle 4 3", r.toString());
    // }

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