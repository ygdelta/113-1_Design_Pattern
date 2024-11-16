package org.ntut.posd2024f.midterm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PriceVisitorTest {
    @Test
    public void testBookVisitor() {
        Book book = new Book("test", 100.0);
        PriceVisitor visitor = new PriceVisitor();
        book.accept(visitor);
        assertEquals(100.0, visitor.getResult(), 0.01);
    }
    
    @Test
    public void testBundleVisitor() {
        Bundle bundle = new Bundle("test");
        bundle.add(new Book("test", 100.0));
        bundle.add(new Book("test", 20.0));
        bundle.add(new Book("test", 80.0));
        PriceVisitor visitor = new PriceVisitor();
        bundle.accept(visitor);
        assertEquals(200.0, visitor.getResult(), 0.01);
    }

    @Test
    public void testDiscountItemBookVisitor() {
        Book book = new Book("test", 100.0);
        DiscountItem discount = new DiscountItem(book, 0.5);
        PriceVisitor visitor = new PriceVisitor();
        discount.accept(visitor);
        assertEquals(50.0, visitor.getResult(), 0.01);
    }

    @Test
    public void testDiscountItemBundleVisitor() {
        Bundle bundle = new Bundle("test");
        bundle.add(new Book("test", 100.0));
        bundle.add(new Book("test", 20.0));
        bundle.add(new Book("test", 80.0));
        DiscountItem discount = new DiscountItem(bundle, 0.5);
        PriceVisitor visitor = new PriceVisitor();
        discount.accept(visitor);
        assertEquals(100.0, visitor.getResult(), 0.01);
    }
}
