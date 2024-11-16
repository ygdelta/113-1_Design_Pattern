package org.ntut.posd2024f.midterm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DiscountItemTest {
    @Test
    public void testDiscountItemCreation() {
        assertTrue(new DiscountItem(new Book("test", 100.0), 0.7) instanceof DiscountItem);
    }
    @Test
    public void testDiscountItemCreationException() {
        assertThrows(IllegalArgumentException.class, () -> {new DiscountItem(new Book("test", 100.0), 3);});
    }
    @Test
    public void testDiscountItemGetTitle() {
        DiscountItem d = new DiscountItem(new Book("test", 100.0), 0.7);
        assertEquals("<test> is on sale! 70% off!", d.getTitle());
    }
}
