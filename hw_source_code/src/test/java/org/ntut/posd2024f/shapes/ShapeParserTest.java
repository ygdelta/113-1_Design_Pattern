package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.xml.soap.Text;

import org.junit.jupiter.api.Test;

public class ShapeParserTest {
    private ShapeParser parser;

    @Test
    void testParseCircle() {
        parser = new ShapeParser("Circle 5.0, color=RED, text=Hello");
        parser.parse();
        List<Shape> shapes = parser.getResult();
        
        assertEquals(1, shapes.size());
        Shape shape = shapes.get(0);
        assertTrue(shape instanceof TextedShape);
        assertTrue(((TextedShape)shape).getShape() instanceof ColoredShape);
        assertTrue(((ColoredShape)((TextedShape)shape).getShape()).getShape() instanceof Circle);

        Circle circle = (Circle)((ColoredShape)((TextedShape)shape).getShape()).getShape();
        assertEquals(5.0, circle.getRadius());
        assertEquals("RED", ((ColoredShape)((TextedShape)shape).getShape()).getColor());
        assertEquals("Hello", ((TextedShape)shape).getText());
    }
    
    @Test
    void testParseRectangle() {
        parser = new ShapeParser("Rectangle 10.0 20.0, color=BLUE");
        parser.parse();
        List<Shape> shapes = parser.getResult();
        
        assertEquals(1, shapes.size());
        Shape shape = shapes.get(0);
        assertTrue(shape instanceof ColoredShape);
        assertTrue(((ColoredShape)shape).getShape() instanceof Rectangle);
        
        Rectangle rect = (Rectangle)((ColoredShape)shape).getShape();
        assertEquals(10.0, rect.getLength());
        assertEquals(20.0, rect.getWidth());
        assertEquals("BLUE", ((ColoredShape)shape).getColor());
    }
    
    @Test
    void testParseTriangle() {
        parser = new ShapeParser("Triangle [0,0] [3,0] [0,4], color=GREEN, text=Triangle1");
        parser.parse();
        List<Shape> shapes = parser.getResult();
        
        assertEquals(1, shapes.size());
        Shape shape = shapes.get(0);
        assertTrue(shape instanceof TextedShape);
        assertTrue(((TextedShape)shape).getShape() instanceof ColoredShape);
        assertTrue(((ColoredShape)((TextedShape)shape).getShape()).getShape() instanceof Triangle);
        
        assertEquals("GREEN", ((ColoredShape)((TextedShape)shape).getShape()).getColor());
        assertEquals("Triangle1", ((TextedShape)shape).getText());
    }
    
    @Test
    void testParseConvexPolygon() {
        parser = new ShapeParser("ConvexPolygon [0,0] [2,0] [2,2] [0,2], color=RED");
        parser.parse();
        List<Shape> shapes = parser.getResult();
        
        assertEquals(1, shapes.size());
        Shape shape = shapes.get(0);
        assertTrue(shape instanceof ColoredShape);
        assertTrue(((ColoredShape)shape).getShape() instanceof ConvexPolygon);
        assertEquals("RED", ((ColoredShape)shape).getColor());
    }
    
    @Test
    void testParseCompoundShape() {
        String input = "CompoundShape, color=RED {\n" +
                      "    Circle 5.0\n" +
                      "    Rectangle 10.0 20.0\n" +
                      "}";
        parser = new ShapeParser(input);
        parser.parse();
        List<Shape> shapes = parser.getResult();
        
        assertEquals(1, shapes.size());
        Shape shape = shapes.get(0);
        assertTrue(((ColoredShape)shape).getShape() instanceof CompoundShape);
        assertEquals("RED", ((ColoredShape)shape).getColor());
        assertEquals(2, ((CompoundShape)((ColoredShape)shape).getShape()).getShapes().size());
    }
    
    @Test
    void testNestedCompoundShape() {
        String input = "CompoundShape, color=RED {\n" +
                      "    Circle 5.0\n" +
                      "    CompoundShape, color=BLUE {\n" +
                      "        Rectangle 10.0 20.0\n" +
                      "    }\n" +
                      "}";
        parser = new ShapeParser(input);
        parser.parse();
        List<Shape> shapes = parser.getResult();
        
        assertEquals(1, shapes.size());
        Shape shape = shapes.get(0);
        CompoundShape compoundShape = (CompoundShape)((ColoredShape)shape).getShape();
        assertEquals(2, compoundShape.getShapes().size());
        Shape nestedShape = compoundShape.getShapes().get(1);
        assertEquals("BLUE", ((ColoredShape)nestedShape).getColor());
    }
    
    @Test
    void testFileConstructor() throws IOException {
        File tempFile = File.createTempFile("test", ".txt");
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("Circle 5.0, color=RED");
        }
        
        parser = new ShapeParser(tempFile);
        parser.parse();
        List<Shape> shapes = parser.getResult();
        assertEquals(1, shapes.size());
        assertTrue(shapes.get(0) instanceof ColoredShape);
        
        tempFile.delete();
    }
    
    @Test
    void testFileNotFound() {
        assertThrows(RuntimeException.class, () -> {
            new ShapeParser(new File("nonexistent.txt"));
        });
    }
    
    @Test
    void testEmptyLines() {
        String input = "Circle 5.0\n" +
                      "\n" +
                      "Rectangle 10.0 20.0";
        parser = new ShapeParser(input);
        parser.parse();
        List<Shape> shapes = parser.getResult();
        assertEquals(2, shapes.size());
    }
    
    @Test
    void testMissingClosingBrace() {
        String input = "CompoundShape {\n" +
                      "    Circle 5.0\n";
        parser = new ShapeParser(input);
        assertThrows(IllegalArgumentException.class, () -> parser.parse());
    }
    
    @Test
    void testMissingOpeningBrace() {
        parser = new ShapeParser("CompoundShape, color=RED");
        assertThrows(IllegalArgumentException.class, () -> parser.parse());
    }
    
    @Test
    void testInvalidVectorFormat() {
        parser = new ShapeParser("Triangle [0,0] [1,1 [2,2]");
        assertThrows(IllegalArgumentException.class, () -> parser.parse());
    }
    
    @Test
    void testMissingCommaInVector() {
        parser = new ShapeParser("Triangle [0 0] [1,1] [2,2]");
        assertThrows(IllegalArgumentException.class, () -> parser.parse());
    }
    
    @Test
    void testMissingBracketInVector() {
        parser = new ShapeParser("Triangle [0,0] 1,1] [2,2]");
        assertThrows(IllegalArgumentException.class, () -> parser.parse());
    }
    
    @Test
    void testShapeWithoutDecorators() {
        parser = new ShapeParser("Circle 5.0");
        parser.parse();
        List<Shape> shapes = parser.getResult();
        assertEquals(1, shapes.size());
        assertTrue(shapes.get(0) instanceof Circle);
    }
    
    @Test
    void testDecoratorOrder() {
        parser = new ShapeParser("Circle 4.0, color=RED, text=Hello");
        parser.parse();
        List<Shape> shapes = parser.getResult();
        assertEquals(1, shapes.size());
        Shape shape = shapes.get(0);
        assertEquals("Hello", ((TextedShape)shape).getText());
        assertEquals("RED", ((ColoredShape)((TextedShape)shape).getShape()).getColor());
    }
}
