package org.ntut.posd2024f.midterm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bundle implements Item {
    private String title;
    private List<Item> items = new ArrayList<>();
    public Bundle(String title) {
        String testStr = title.replace(" ", "");
        if (testStr.equals("")) {
            throw new IllegalArgumentException("The bundle should have a title.");
        }
        this.title = title;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void add(Item item) {
        this.items.add(item);
    }

    @Override
    public <T> void accept(ItemVisitor<T> visitor) {
        visitor.visitBundle(this);
    }

    @Override
    public Iterator<Item> iterator() {
        return this.items.iterator();
    }
}
