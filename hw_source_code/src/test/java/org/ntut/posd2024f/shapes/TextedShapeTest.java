package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TextedShapeTest {
    private Shape shape;
    private String text;

    @BeforeEach
    public void SetUp() {
        shape = new Circle(1.0);
        text = new String("test");
    }

    @Test
    public void TextedShapeCreation() throws ShapeException {
        Shape c = new Circle(1.0);
        String t = new String("test");
        new TextedShape(c, t);
    }

    @Test
    public void TextedShapeArea() {
        TextedShape test = new TextedShape(shape, text);
        double ans = Math.PI * 1.0 * 1.0;
        assertEquals(ans, test.area(), 0.01);
    }
    
    @Test
    public void TextedShapePerimeter() {
        TextedShape test = new TextedShape(shape, text);
        double ans = 2 * 1.0 * Math.PI;
        assertEquals(ans, test.perimeter(), 0.01);
    }

    @Test
    public void TextShapeGetText() {
        TextedShape test = new TextedShape(shape, text);
        String ans = "test";
        assertEquals(ans, test.getText()); 
    }

    @Test
    public void TextShapeGetShape() {
        TextedShape test = new TextedShape(shape, text);
        Shape ans = new Circle(1.0);
        assertEquals(ans.perimeter(), test.getShape().perimeter()); 
        assertEquals(ans.area(), test.getShape().area());
    }
}
