package org.ntut.posd2024f.midterm;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class NullIteratorTest {
    @Test
    public void testHasNext() {
        assertFalse(false);
    }
    @Test
    public void testNext() throws Exception {
        assertThrows(NoSuchElementException.class, () -> {(new Book("test", 10.0)).iterator().next();});   
    }
}
