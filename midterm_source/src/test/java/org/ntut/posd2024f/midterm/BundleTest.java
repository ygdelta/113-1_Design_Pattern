package org.ntut.posd2024f.midterm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class BundleTest {
    @Test
    public void testBundleCreation() {
        new Bundle("test");
    }
    @Test
    public void testBundleGetTitle() {
        Bundle b = new Bundle("test");
        assertEquals(b.getTitle(), "test");
    }
    @Test
    public void testBundleAdd() {
        Bundle b = new Bundle("test");
        b.add(new Book("book1", 100.0));
        Iterator<Item> it = b.iterator();
        int index = 0;
        while(it.hasNext()) {
            it.next();
            index++;
        }
        assertEquals(1, index);
    }
    @Test
    public void testBundleIterator() {
        Bundle b = new Bundle("test");
        b.add(new Book("book1", 100.0));
        b.add(new Book("book1", 100.0));
        b.add(new Book("book1", 100.0));
        b.add(new Book("book1", 100.0));
        b.add(new Book("book1", 100.0));
        Iterator<Item> it = b.iterator();
        int index = 0;
        while(it.hasNext()) {
            it.next();
            index++;
        }
        assertEquals(5, index);
    }
}
