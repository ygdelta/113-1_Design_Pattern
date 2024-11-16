package org.ntut.posd2024f.midterm;

import java.util.Iterator;

public class PriceVisitor implements ItemVisitor<Double> {
    private double price = 0.0;

    @Override
    public void visitBook(Book book) {
        price += book.getPrice();
    }

    @Override
    public void visitBundle(Bundle bundle) {
        Iterator<Item> it = bundle.iterator();
        while(it.hasNext()) {
            Item item = it.next();
            if (item instanceof Bundle) {
                PriceVisitor visitor = new PriceVisitor();
                visitor.visitBundle((Bundle)item);
                price += visitor.getResult();
            }
            else if (item instanceof DiscountItem) {
                PriceVisitor visitor = new PriceVisitor();
                visitor.visitDiscountItem((DiscountItem)item);
                price += visitor.getResult();
            }
            else {
                Book book = (Book)item;
                price += book.getPrice();
            }
        }
    }

    @Override
    public void visitDiscountItem(DiscountItem discountItem) {
        if (discountItem.getItem() instanceof Book) {
            Book b = (Book) discountItem.getItem();
            price += b.getPrice() * (1 - discountItem.getDiscount());
        }
        else if (discountItem.getItem() instanceof Bundle) {
            Bundle b = (Bundle) discountItem.getItem();
            PriceVisitor visitor = new PriceVisitor();
            visitor.visitBundle(b);
            price += visitor.getResult() * (1 - discountItem.getDiscount());
        }
        else if (discountItem.getItem() instanceof DiscountItem) {
            DiscountItem d = (DiscountItem)discountItem.getItem();
            PriceVisitor visitor = new PriceVisitor();
            visitor.visitDiscountItem(d);
            price += visitor.getResult() * (1 - discountItem.getDiscount());
        }
    }

    @Override
    public Double getResult() {
        return this.price;
    }
}
