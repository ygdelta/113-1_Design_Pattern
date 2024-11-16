package org.ntut.posd2024f.midterm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class DFSIteratorTest {
    @Test
    public void testDFSBook() {
        Book book = new Book("test", 1.0);
        Iterator<Item> it = book.dfsIterator();
        while(it.hasNext()) {
            assertEquals(book, it.next());
        }
    }

    @Test
    public void testDFSBundle() {
        Bundle bundle1 = new Bundle("bundle1");
        Bundle bundle2 = new Bundle("bundle2");
        bundle1.add(new Book("title1", 1.0));
        bundle1.add(new Book("title2", 1.0));
        bundle2.add(new Book("title3", 1.0));
        Bundle bundle3 = new Bundle("bundle3");
        bundle3.add(bundle1);
        bundle3.add(bundle2);
        Iterator<Item> it = bundle3.dfsIterator();
        assertEquals("bundle3", it.next().getTitle());
        assertEquals("bundle1", it.next().getTitle());
        assertEquals("title1", it.next().getTitle());
        assertEquals("title2", it.next().getTitle());
        assertEquals("bundle2", it.next().getTitle());
        assertEquals("title3", it.next().getTitle());
    }
}
