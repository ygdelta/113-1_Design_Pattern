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
        // TODO: Creation test?
    }

    @Test
    public void testVectorLength() {
        double ans = Math.sqrt((3.0 * 3.0) + (4.0 * 4.0));
        assertEquals(ans, v.length(), 0.01);
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
        assertEquals(ans, v1.subtract(v2));
    }
}
