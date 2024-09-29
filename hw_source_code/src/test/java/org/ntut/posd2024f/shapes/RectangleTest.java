package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RectangleTest {
    // e.g. Rectangle r = new rectangle(...)    
    @Test(expected = Exception.class)
    public void testException1() throws Exception {
        Rectangle r = new Rectangle(-3.3, 3);
    }

    public void testRectangle() throws Exception {
        Rectangle r = new Rectangle(4, 3);
        assertEquals("Rectangle 4 3", r.toString());
    }
}