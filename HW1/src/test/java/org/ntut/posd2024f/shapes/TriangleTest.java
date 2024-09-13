package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TriangleTest {
    // Triangle t = new Triangle(...)
    @Test(expected = Exception.class)
    public void testException1() throws Exception {
        Triangle t = new Triangle(-1.0, 3, 4);
    }

    @Test(expected = Exception.class)
    public void testException2() throws Exception {
        Triangle t = new Triangle(10, 3, 4);
    }

    public void testTriangle() throws Exception {
        Triangle t = new Triangle(3, 4, 5);
        assertEquals("Triangle 3 4 5", t.toString());
    }
}