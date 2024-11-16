package org.ntut.posd2024f.midterm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class ItemTest {
    @Test
    public void testBookCreation() {
        Item i = new Book("title", 1.0);
        assertTrue(i instanceof Item);
    }
    @Test
    public void testBookGetTitle() {
        Item i = new Book("title", 1.0);
        assertEquals(i.getTitle(), "title");
    }
    @Test
    public void testBundleCreation() {
        Item b = new Bundle("test");
        assertTrue(b instanceof Bundle);
    }
    @Test
    public void testBundleGetTitle() {
        Item b = new Bundle("test");
        assertEquals(b.getTitle(), "test");
    }
    @Test
    public void testDiscountItemCreation() {
        Item discount = new DiscountItem(new Book("test", 100.0), 0.7);
        assertTrue(discount instanceof DiscountItem);
    }
    @Test
    public void testDiscountItemGetTitle() {
        Item d = new DiscountItem(new Book("test", 100.0), 0.7);
        assertEquals("<test> is on sale! 70% off!", d.getTitle());
    }
    @Test
    public void testIterator() {
        Item i = new Book("title", 1.0);
        Item b = new Bundle("test");
        Item d = new DiscountItem(new Book("test", 100.0), 0.7);
        Iterator<Item> it1 = i.iterator();
        Iterator<Item> it2 = b.iterator();
        Iterator<Item> it3 = d.iterator();
        assertTrue(it1 instanceof Iterator);
        assertTrue(it2 instanceof Iterator);
        assertTrue(it3 instanceof Iterator);
    }
}
