package org.ntut.posd2024f.midterm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BookTest {    
    @Test
    public void testBookCreation() {
        Book i = new Book("title", 1.0);
        assertTrue(i instanceof Book);
    }
    @Test
    public void testBookGetTitle() {
        Book i = new Book("title", 1.0);
        assertEquals(i.getTitle(), "title");
    }
    @Test
    public void testBookGetPrice() {
        Book i = new Book("title", 1.0);
        assertEquals(i.getPrice(), 1.0, 0.01);
    }
}
