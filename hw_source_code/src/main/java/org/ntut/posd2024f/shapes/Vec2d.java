package org.ntut.posd2024f.shapes;

public class Vec2d {
    // TODO: Implement the class Vec2d
    private double x;
    private double y;

    public Vec2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double length() {
        return Math.sqrt((this.x * this.x) + (this.y * this.y));
    }

    public int dot(Vec2d v2) {
        return (int)(this.x * v2.getX() + this.y * v2.getY());
    }

    public int cross(Vec2d v2) {
        return (int)(this.x * v2.getY() + this.y * v2.getX());
    }

    public Vec2d subtract(Vec2d v2) {
        int x = this.x - v2.getX();
        int y = this.y - v2.getY();
        Vec2d ans = new Vec2d(x, y);
    }
}
