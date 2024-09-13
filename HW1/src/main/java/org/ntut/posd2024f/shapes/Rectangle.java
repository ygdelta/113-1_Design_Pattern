package org.ntut.posd2024f.shapes;
import java.lang.String;

public class Rectangle implements Shape {
    private double length;
    private double width;
    public Rectangle(double length, double width) throws Exception {
        if(length <= 0 || width <= 0) {
            throw new Exception("It's not a rectangle!");
        }
        this.length = length;
        this.width = width;
    }

	public double area() {
        return this.length * this.width;
    }
    
    public double perimeter() {
        return (this.length + this.width) * 2;
    }

    public String toString() {
        return new String("Rectangle " + Double.valueOf(this.length) + " " + Double.valueOf(this.width));
    }
}