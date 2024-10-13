package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrettyPrintVisitorTest {
    private PrettyPrintVisitor visitor;
    
    @BeforeEach
    public void SetUp() {
        visitor = new PrettyPrintVisitor();
    }

    @Test
    public void testPrettyPrintVisitorCircle() {
        Shape c1 = new Circle(5.0);
        c1.accept(visitor);
        assertEquals("Circle 5.0", visitor.getResult());
    }

    @Test
    public void testPrettyPrintVisitorRectangle() {
        Shape r1 = new Rectangle(4.0, 3.0);
        r1.accept(visitor);
        assertEquals("Rectangle 4.0 3.0", visitor.getResult());
    }

    @Test
    public void FindShapeVisitorTriangle() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(3, 0));
        vectors.add(new TwoDimensionalVector(0, 4));
        Shape t1 = new Triangle(vectors);
        t1.accept(visitor);
        assertEquals("Triangle [0,0] [3,0] [0,4]", visitor.getResult());
    }

    @Test
    public void FindShapeVisitorConvexPolygon() {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(3, 0));
        vectors.add(new TwoDimensionalVector(3, 4));
        vectors.add(new TwoDimensionalVector(0, 4));
        Shape convex = new ConvexPolygon(vectors);
        convex.accept(visitor);
        assertEquals("ConvexPolygon [0,0] [3,0] [3,4] [0,4]", visitor.getResult());
    }

    @Test
    public void FindShapeVisitorCompoundShape() {
        Shape r1 = new Rectangle(5.0, 3.0);
        Shape c1 = new Circle(1.0);
        List<Shape> comList = new ArrayList<>();
        comList.add(r1); comList.add(c1);
        Shape compound = new CompoundShape(comList);
        compound.accept(visitor);
        assertEquals("CompoundShape {\n  Rectangle 5.0 3.0\n  Circle 1.0\n}", visitor.getResult());
    }

    @Test
    public void testPrettyPrintVisitorTextedShape() {
        Shape c1 = new Circle(5.0);
        String text = "test";
        Shape s = new TextedShape(c1, text);
        s.accept(visitor);
        assertEquals("Circle 5.0, text: test", visitor.getResult());
    }
    
    @Test
    public void testPrettyPrintVisitorColoredShape() {
        Shape c1 = new Circle(5.0);
        String color = "RED";
        Shape s = new ColoredShape(c1, color);
        s.accept(visitor);
        assertEquals("\033[0;31mCircle 5.0\033[0m", visitor.getResult());

    }
}
