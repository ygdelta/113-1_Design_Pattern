package org.ntut.posd2024f.midterm;

public class Book implements Item {
    private String title = "";
    private double price = 0.0;
    public Book(String title, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("The price should be greater than or equal to 0.");
        }
        String testStr = title.replace(" ", "");
        if (testStr.equals("")) {
            throw new IllegalArgumentException("The book should have a title.");
        }
        this.title = title;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public <T> void accept(ItemVisitor<T> visitor) {
        visitor.visitBook(this);
    }
}
