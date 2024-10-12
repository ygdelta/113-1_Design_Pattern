package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class NullIteratorTest {
    @Test//TODO
    public void testNullIterator() throws Exception {
        assertThrows(NoSuchElementException.class, () -> (new Circle(1.0)).iterator().next(), "Null iterator does not point to any element.");
    }

    @Test
    public void testCompoundShapeIterator() {
        List<Shape> shapes = new ArrayList<>();
        Shape test = new CompoundShape(shapes);
        Iterator<Shape> it = test.iterator();
        int index = 0;
        while (it.hasNext()) {
            Shape s = it.next();
            assertEquals(shapes.get(index), s);
            index++;
        }
    }
}
