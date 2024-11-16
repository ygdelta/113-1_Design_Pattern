package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShapeBuilderTest {
    private ShapeBuilder builder;
    @BeforeEach
    void Setup() {
        builder = new ShapeBuilder();
    }

    @Test
    public void testShapeBuilder() {
        assertEquals(0, 0);
    }

    @Test
    public void testBuildCircle() {
        builder.buildCircle(10, null, null);
        assertEquals(10 * 10 * Math.PI, builder.getResult().get(0).area());
        assertEquals(2 * 10 * Math.PI, builder.getResult().get(0).perimeter());
    }

    @Test
    public void testBuildCircleText() {
        builder.buildCircle(10, null, "test");
        List<Shape> shapes = builder.getResult();
        assertEquals(10 * 10 * Math.PI, shapes.get(0).area());
        assertEquals(2 * 10 * Math.PI, shapes.get(0).perimeter());
        assertEquals("test", ((TextedShape)shapes.get(0)).getText());
    }

    @Test
    public void testBuildCircleColor() {
        builder.buildCircle(10, "RED", null);
        List<Shape> shapes = builder.getResult();
        assertEquals(10 * 10 * Math.PI, shapes.get(0).area());
        assertEquals(2 * 10 * Math.PI, shapes.get(0).perimeter());
        assertEquals("RED", ((ColoredShape)shapes.get(0)).getColor());
    }

    @Test
    public void testBuildCircleColorText() {
        builder.buildCircle(10, "RED", "test");
        List<Shape> shapes = builder.getResult();
        assertEquals(10 * 10 * Math.PI, shapes.get(0).area());
        assertEquals(2 * 10 * Math.PI, shapes.get(0).perimeter());
        assertEquals("test", ((TextedShape)shapes.get(0)).getText());
        assertEquals("RED", ((ColoredShape)((TextedShape)shapes.get(0)).getShape()).getColor());
    }

    @Test
    public void testBuildRectangle() {
        builder.buildRectangle(2, 5, null, null);
        Shape shape = builder.getResult().get(0);
        assertEquals(2 * 5, shape.area());
        assertEquals(14, shape.perimeter());
    }

    @Test
    public void testBuildRectangleText() {
        builder.buildRectangle(2, 5, null, "test");
        Shape shape = builder.getResult().get(0);
        assertEquals(2 * 5, shape.area());
        assertEquals(14, shape.perimeter());
        assertEquals("test", ((TextedShape)shape).getText());
    }

    @Test
    public void testBuildRectangleColor() {
        builder.buildRectangle(2, 5, "RED", null);
        Shape shape = builder.getResult().get(0);
        assertEquals(2 * 5, shape.area());
        assertEquals(14, shape.perimeter());
        assertEquals("RED", ((ColoredShape)shape).getColor());
    }

    @Test
    public void testBuildRectangleColorText() {
        builder.buildRectangle(2, 5, "RED", "test");
        Shape shape = builder.getResult().get(0);
        assertEquals(2 * 5, shape.area());
        assertEquals(14, shape.perimeter());
        assertEquals("test", ((TextedShape)shape).getText());
        assertEquals("RED", ((ColoredShape)((TextedShape)shape).getShape()).getColor());
    }

    @Test
    public void testBuildTriangle() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(2, 0));
        vectors.add(new TwoDimensionalVector(0, 5));
        builder.buildTriangle(vectors, null, null);
        Shape shape = builder.getResult().get(0);
        assertEquals(5, shape.area());
        assertEquals(12.385, shape.perimeter(), 0.01);
    }

    @Test
    public void testBuildTriangleText() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(2, 0));
        vectors.add(new TwoDimensionalVector(0, 5));
        builder.buildTriangle(vectors, null, "test");
        Shape shape = builder.getResult().get(0);
        assertEquals(5, shape.area());
        assertEquals(12.385, shape.perimeter(), 0.01);
        assertEquals("test", ((TextedShape)shape).getText());
    }

    @Test
    public void testBuildTriangleColor() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(2, 0));
        vectors.add(new TwoDimensionalVector(0, 5));
        builder.buildTriangle(vectors, "RED", null);
        Shape shape = builder.getResult().get(0);
        assertEquals(5, shape.area());
        assertEquals(12.385, shape.perimeter(), 0.01);
        assertEquals("RED", ((ColoredShape)shape).getColor());
    }

    @Test
    public void testBuildTriangleColorText() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(2, 0));
        vectors.add(new TwoDimensionalVector(0, 5));
        builder.buildTriangle(vectors, "RED", "test");
        Shape shape = builder.getResult().get(0);
        assertEquals(5, shape.area());
        assertEquals(12.385, shape.perimeter(), 0.01);
        assertEquals("test", ((TextedShape)shape).getText());
        assertEquals("RED", ((ColoredShape)((TextedShape)shape).getShape()).getColor());
    }

    @Test
    public void testBuildConvexPolygon() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(2, 0));
        vectors.add(new TwoDimensionalVector(0, 5));
        builder.buildConvexPolygon(vectors, null, null);
        Shape shape = builder.getResult().get(0);
        assertEquals(5, shape.area());
        assertEquals(12.385, shape.perimeter(), 0.01);
    }

    @Test
    public void testBuildConvexPolygonText() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(2, 0));
        vectors.add(new TwoDimensionalVector(0, 5));
        builder.buildConvexPolygon(vectors, null, "test");
        Shape shape = builder.getResult().get(0);
        assertEquals(5, shape.area());
        assertEquals(12.385, shape.perimeter(), 0.01);
        assertEquals("test", ((TextedShape)shape).getText());
    }

    @Test
    public void testBuildConvexPolygonColor() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(2, 0));
        vectors.add(new TwoDimensionalVector(0, 5));
        builder.buildConvexPolygon(vectors, "RED", null);
        Shape shape = builder.getResult().get(0);
        assertEquals(5, shape.area());
        assertEquals(12.385, shape.perimeter(), 0.01);
        assertEquals("RED", ((ColoredShape)shape).getColor());
    }

    @Test
    public void testBuildConvexPolygonColorText() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(2, 0));
        vectors.add(new TwoDimensionalVector(0, 5));
        builder.buildConvexPolygon(vectors, "RED", "test");
        Shape shape = builder.getResult().get(0);
        assertEquals(5, shape.area());
        assertEquals(12.385, shape.perimeter(), 0.01);
        assertEquals("test", ((TextedShape)shape).getText());
        assertEquals("RED", ((ColoredShape)((TextedShape)shape).getShape()).getColor());
    }

    @Test
    public void testBuildCompound() {
        builder.beginBuildCompoundShape(null, null);
        builder.buildCircle(10, null, null);
        builder.buildRectangle(2, 5, null, null);
        builder.endBuildCompoundShape();
        Shape shape = builder.getResult().get(0);
        assertEquals(324.1592, shape.area(), 0.01);
        assertEquals(76.8318, shape.perimeter(), 0.01);
    }

    @Test
    public void testBuildCompoundText() {
        builder.beginBuildCompoundShape(null, "test");
        builder.buildCircle(10, null, null);
        builder.buildRectangle(2, 5, null, null);
        builder.endBuildCompoundShape();
        Shape shape = builder.getResult().get(0);
        assertEquals(324.1592, shape.area(), 0.01);
        assertEquals(76.8318, shape.perimeter(), 0.01);
        assertEquals("test", ((TextedShape)shape).getText());
    }

    @Test
    public void testBuildCompoundColor() {
        builder.beginBuildCompoundShape("RED", null);
        builder.buildCircle(10, null, null);
        builder.buildRectangle(2, 5, null, null);
        builder.endBuildCompoundShape();
        Shape shape = builder.getResult().get(0);
        assertEquals(324.1592, shape.area(), 0.01);
        assertEquals(76.8318, shape.perimeter(), 0.01);
        assertEquals("RED", ((ColoredShape)shape).getColor());
    }

    @Test
    public void testBuildCompoundColorText() {
        builder.beginBuildCompoundShape("RED", "test");
        builder.buildCircle(10, null, null);
        builder.buildRectangle(2, 5, null, null);
        builder.endBuildCompoundShape();
        Shape shape = builder.getResult().get(0);
        assertEquals(324.1592, shape.area(), 0.01);
        assertEquals(76.8318, shape.perimeter(), 0.01);
        assertEquals("test", ((TextedShape)shape).getText());
        assertEquals("RED", ((ColoredShape)((TextedShape)shape).getShape()).getColor());
    }
}
