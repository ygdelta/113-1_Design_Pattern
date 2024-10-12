package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ColoredShapeTest {
    private Shape shape;
    private String color;

    @BeforeEach
    public void SetUp() {
        shape = new Circle(1.0);
        color = "RED";
    }

    @Test
    public void ColoredShapeCreation() throws ShapeException {
        Shape c = new Circle(1.0);
        String color = "RED";
        new ColoredShape(c, color);
    }

    @Test
    public void ColoredShapeArea() {
        ColoredShape coloredShape = new ColoredShape(shape, color);
        double ans = 1.0 * 1.0 * Math.PI;
        assertEquals(ans, coloredShape.area(), 0.01);
    }    

    @Test
    public void ColoredShapePerimeter() {
        ColoredShape test = new ColoredShape(shape, color);
        double ans = 2 * 1.0 * Math.PI;
        assertEquals(ans, test.perimeter(), 0.01);
    }

    @Test
    public void ColoredShapeGetColor() {
        ColoredShape test = new ColoredShape(shape, color);
        String ans = "RED";
        assertEquals(ans, test.getColor()); 
    }
}
