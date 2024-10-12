package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ConvexPolygonTest {
    private ConvexPolygon c;
    private List<TwoDimensionalVector> vectors;

    @BeforeEach
    public void SetUp() {
        this.vectors = new ArrayList<>();
        this.vectors.add(new TwoDimensionalVector(0, 3));
        this.vectors.add(new TwoDimensionalVector(2, 0));
        this.vectors.add(new TwoDimensionalVector(0, -8));
        this.vectors.add(new TwoDimensionalVector(-1, 0));
        this.c = new ConvexPolygon(vectors);
    }

    @Test// TODO
    public void testConvexCreationException() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(0, 3));
        vectors.add(new TwoDimensionalVector(0, -8));
        vectors.add(new TwoDimensionalVector(2, 0));
        vectors.add(new TwoDimensionalVector(-1, 0));
        assertThrows(ShapeException.class, () -> new ConvexPolygon(vectors), "It's not a convex polygon!");
    } 

    @Test
    public void testConvexCreationCounterClockWise() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(3, 0));
        vectors.add(new TwoDimensionalVector(3, 4));
        vectors.add(new TwoDimensionalVector(-5, 4));
        vectors.add(new TwoDimensionalVector(-5, 0));
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