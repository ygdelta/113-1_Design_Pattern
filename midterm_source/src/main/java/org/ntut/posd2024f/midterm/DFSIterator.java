package org.ntut.posd2024f.midterm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class DFSIterator implements Iterator<Item> {
    private List<Item> items = new ArrayList<>();
    private int index = -1;
    public DFSIterator(Item item) {
        this.items.add(item);
        this.insertElements(item);
    }

    private void insertElements(Item item) {
        Iterator<Item> it = item.iterator();
        while(it.hasNext()) {
            Item obj = it.next();
            this.items.add(obj);
            if (obj instanceof Bundle) {
                insertElements(obj);
            }
            else if (obj instanceof DiscountItem) {          
                DiscountItem d = (DiscountItem) obj;
                if (d.getItem() instanceof Bundle) {
                    this.insertElements(d.getItem());
                }
                else {
                    this.insertElements(d.getItem());
                }
            }
        }
    }
    @Override
    public boolean hasNext() {
        if (index + 1 <= this.items.size() - 1) {
            return true;
        }
        return false;
    }
    @Override 
    public Item next() {
        if (this.index + 1 > this.items.size() - 1) {
            throw new NoSuchElementException("No more element.");
        }
        Item result = this.items.get(index + 1);
        index++;
        return result;
    }
}
