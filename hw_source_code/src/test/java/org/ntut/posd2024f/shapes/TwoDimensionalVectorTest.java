package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TwoDimensionalVectorTest {
    private TwoDimensionalVector v1;
    private TwoDimensionalVector v2;

    @BeforeEach
    public void SetUp() {
        v1 = new TwoDimensionalVector(3, 4);
        v2 = new TwoDimensionalVector(1, 2);
    }

    @Test
    public void testVectorCreation() {
        int x = 1;
        int y = 2;
        TwoDimensionalVector v = new TwoDimensionalVector(x, y);
        assertEquals(x, v.getX());
        assertEquals(y, v.getY());
    }

    @Test
    public void testVectorLength() {
        double ans = Math.sqrt((3.0 * 3.0) + (4.0 * 4.0));
        assertEquals(ans, v1.length(), 0.01);
    }

    @Test
    public void testVectorDot() {
        int ans = 3 * 1 + 4 * 2;
        assertEquals(ans, v1.dot(v2));
    }

    @Test
    public void testVectorCross() {
        int ans = 3 * 2 - 4 * 1;
        assertEquals(ans, v1.cross(v2));
    }

    @Test
    public void testVectorSubtract() {
        TwoDimensionalVector ans = new TwoDimensionalVector(2, 2);
        TwoDimensionalVector result = v1.subtract(v2);
        assertEquals(ans.getX(), result.getX());
        assertEquals(ans.getY(), result.getX());
    }
}
