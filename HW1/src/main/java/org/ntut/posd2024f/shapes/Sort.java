package org.ntut.posd2024f.shapes;

import java.util.Comparator;

public class Sort{
    public static Comparator<Shape> BY_AREA_ASCENDING = new ByAreaAscending();
    public static Comparator<Shape> BY_AREA_DESCENDING = new ByAreaDescending();
    public static Comparator<Shape> BY_PERIMETER_ASCENDING = new ByPerimeterAscending();
    public static Comparator<Shape> BY_PERIMETER_DESCENDING = new ByPerimeterDescending();

    private static class ByAreaAscending implements Comparator<Shape> {
        public int compare(Shape left, Shape right){
            return (int) (left.area() - right.area());
        }
    }

    private static class ByAreaDescending implements Comparator<Shape> {
        public int compare(Shape left, Shape right){
            return (int) (right.area() - left.area());
        }
    }

    private static class ByPerimeterAscending implements Comparator<Shape> {
        public int compare(Shape left, Shape right){
            return (int) (left.perimeter() - right.perimeter());
        }
    }

    private static class ByPerimeterDescending implements Comparator<Shape> {
        public int compare(Shape left, Shape right){
            return (int) (right.perimeter() - left.perimeter());
        }
    }    
}


