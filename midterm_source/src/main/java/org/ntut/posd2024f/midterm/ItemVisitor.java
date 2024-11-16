package org.ntut.posd2024f.midterm;

public interface ItemVisitor<T> {
    public void visitBook(Book book);
    public void visitBundle(Bundle bundle);
    public void visitDiscountItem(DiscountItem discountItem);
    public T getResult();
}
