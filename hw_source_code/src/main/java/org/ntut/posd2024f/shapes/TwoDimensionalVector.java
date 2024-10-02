package org.ntut.posd2024f.shapes;

public class TwoDimensionalVector {
    private int x;
    private int y;

    public TwoDimensionalVector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double length() {
        return Math.sqrt((this.x * this.x) + (this.y * this.y));
    }

    public int dot(TwoDimensionalVector v) {
        return this.x * v.getX() + this.y * v.getY();
    }

    public int cross(TwoDimensionalVector v) {
        return this.x * v.getY() - this.y * v.getX();
    }

    public TwoDimensionalVector subtract(TwoDimensionalVector v) {
        int x = this.x - v.getX();
        int y = this.y - v.getY();
        return new TwoDimensionalVector(x, y);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean isZero() {
        return (this.x == 0 && this.y == 0);
    }

    public boolean isParallel(TwoDimensionalVector v) {
        if (this.x == 0 && v.getX() == 0) {
            return true;
        }
        if (this.y == 0 && v.getY() == 0) {
            return true;
        }
        double c = this.x / v.getX();
        return (this.y / v.getY() == c);
    }
}