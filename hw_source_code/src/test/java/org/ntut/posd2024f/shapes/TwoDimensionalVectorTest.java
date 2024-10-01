package org.ntut.posd2024f.shapes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TwoDimensionalVectorTest {
    private Vec2d v1;
    private Vec2d v2;

    @Before
    public void SetUp() {
        v1 = new Vec2d(3.0, 4.0);
        v2 = new Vec2d(1.0, 2.0);
    }

    @Test
    public void testVectorCreation() {
        double x = 1.0;
        double y = 2.0;
        Vec2d v = new Vec2d(x, y);
        assertEquals(x, v.getX(), 0.01);
        assertEquals(y, v.getY(), 0.01);
    }

    @Test
    public void testVectorLength() {
        double ans = Math.sqrt((3.0 * 3.0) + (4.0 * 4.0));
        assertEquals(ans, v1.length(), 0.01);
    }

    @Test
    public void testVectorDot() {
        int ans = (int)(3.0 * 1.0 + 4.0 * 2.0);
        assertEquals(ans, v1.dot(v2));
    }

    @Test
    public void testVectorCross() {
        int ans = (int)(3.0 * 2.0 + 4.0 * 1.0);
        assertEquals(ans, v1.cross(v2));
    }

    @Test
    public void testVectorSubtract() {
        Vec2d ans = new Vec2d(2.0, 2.0);
        Vec2d result = v1.subtract(v2);
        assertEquals(ans.getX(), result.getX(), 0.01);
        assertEquals(ans.getY(), result.getX(), 0.01);
    }
}
