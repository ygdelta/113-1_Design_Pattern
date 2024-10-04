package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class NullIteratorTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testNullIterator() throws Exception {
        thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("Null iterator does not point to any element.");
        (new Circle(1.0)).iterator().next();
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
