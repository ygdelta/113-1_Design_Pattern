package org.ntut.posd2024f.midterm;

import java.text.DecimalFormat;
import java.util.Iterator;

public class DiscountItem implements Item {
    private Item item;
    private double discount;
    private DecimalFormat format = new DecimalFormat("##.##");
    public DiscountItem(Item item, double discount) throws IllegalArgumentException {
        if (discount > 1 || discount < 0) {
            throw new IllegalArgumentException("The discount should be between 0 and 1.");
        }
        this.item = item;
        this.discount = discount;
    }

    public Item getItem() {
        return this.item;
    }

    public double getDiscount() {
        return this.discount;
    }

    @Override
    public String getTitle() {
        // format.format(discount).substring(1, format.format(discount).length())
        //return "<" + this.item.getTitle() + "> is on sale! " + Double.toString(discount * 100).format("##.##", ) + "% off!"; 
        //.substring(1, format.format(discount).length()) 
        return "<" + this.item.getTitle() + "> is on sale! " + format.format(discount * 100) + "% off!"; 
    }

    @Override
    public <T> void accept(ItemVisitor<T> visitor) {
        visitor.visitDiscountItem(this);
    }

    @Override
    public Iterator<Item> iterator() {
        return this.item.iterator();
    }
}
