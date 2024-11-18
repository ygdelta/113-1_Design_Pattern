package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ShapeParserTest {
    private ShapeParser parser;
    @Test
    public void testCircleParser() {
        parser = new ShapeParser("Circle 1.0");
        parser.parse();
        Shape c = parser.getResult().get(0);
        assertEquals(Math.PI, c.area(), 0.01);
        assertEquals(2 * Math.PI, c.perimeter(), 0.01);
    }

    @Test
    public void testCircleColorParser() {
        parser = new ShapeParser("Circle 1.0, color=RED");
        parser.parse();
        Shape c = parser.getResult().get(0);
        assertEquals(Math.PI, c.area(), 0.01);
        assertEquals(2 * Math.PI, c.perimeter(), 0.01);
        assertEquals("RED", ((ColoredShape)c).getColor());
    }

    @Test
    public void testCircleTextParser() {
        parser = new ShapeParser("Circle 1.0, text=test");
        parser.parse();
        Shape c = parser.getResult().get(0);
        assertEquals(Math.PI, c.area(), 0.01);
        assertEquals(2 * Math.PI, c.perimeter(), 0.01);
        assertEquals("test", ((TextedShape)c).getText());
    }

    @Test
    public void testCircleColorTextParser() {
        parser = new ShapeParser("Circle 1.0, color=RED, text=test");
        parser.parse();
        Shape c = parser.getResult().get(0);
        assertEquals(Math.PI, c.area(), 0.01);
        assertEquals(2 * Math.PI, c.perimeter(), 0.01);
        assertEquals("test", ((TextedShape)c).getText());
        ColoredShape colorShape = (ColoredShape)((TextedShape)c).getShape();
        assertEquals("RED", colorShape.getColor());
    }
    
    @Test
    public void testEmptyCompoundShape() {
        parser = new ShapeParser("CompoundShape {\n}");
        parser.parse();
        Shape c = parser.getResult().get(0);
        assertTrue(c instanceof CompoundShape);
    }
}
