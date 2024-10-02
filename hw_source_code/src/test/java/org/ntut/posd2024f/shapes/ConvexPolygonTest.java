package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ConvexPolygonTest {
    private ConvexPolygon c;
    private List<TwoDimensionalVector> vectors;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void SetUp() {
        this.vectors = new ArrayList<>();
        this.vectors.add(new TwoDimensionalVector(0, 3));
        this.vectors.add(new TwoDimensionalVector(2, 0));
        this.vectors.add(new TwoDimensionalVector(0, -8));
        this.vectors.add(new TwoDimensionalVector(-1, 0));
        this.c = new ConvexPolygon(vectors);
    }

    @Test
    public void testConvexCreationException() {
        thrown.expect(ShapeException.class);
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(0, 3));
        vectors.add(new TwoDimensionalVector(0, -8));
        vectors.add(new TwoDimensionalVector(2, 0));
        vectors.add(new TwoDimensionalVector(-1, 0));
        new ConvexPolygon(vectors);
    } 

    @Test
    public void testConvexCreation() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(0, 3));
        vectors.add(new TwoDimensionalVector(2, 0));
        vectors.add(new TwoDimensionalVector(0, -8));
        vectors.add(new TwoDimensionalVector(-1, 0));
        new ConvexPolygon(vectors);
    }

    @Test
    public void testConvexPerimeter() {
        double ans = 0;
        for (int i = 0; i < this.vectors.size() - 1; i++) {
            ans += this.vectors.get(i).subtract(this.vectors.get(i + 1)).length();
        }
        ans += this.vectors.get(vectors.size() - 1).subtract(this.vectors.get(0)).length();
        assertEquals(ans, this.c.perimeter(), 0.01);
    }

    @Test
    public void testConvexArea() {
        double ans = (1 + 2) * (3 + 8) / 2.0;
        assertEquals(ans, this.c.area(), 0.01);
    }
}