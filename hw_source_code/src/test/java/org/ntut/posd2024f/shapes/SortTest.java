package org.ntut.posd2024f.shapes;

import java.util.ArrayList;
import java.util.Collections;
import static org.junit.Assert.*;
import org.junit.Test;

public class SortTest {
    private ArrayList<Shape> arr = new ArrayList<Shape>();

    public SortTest() throws ShapeException {
        // arr.add(new Triangle(3, 4, 5));
        arr.add(new Circle(5.5));
        arr.add(new Rectangle(1, 2));
    }

    @Test
    public void testAreaSortAec() throws ShapeException {
        ArrayList<Shape> expecList = new ArrayList<Shape>();
        expecList.add(new Rectangle(1, 2));
        // expecList.add(new Triangle(3, 4, 5));
        expecList.add(new Circle(5.5));
        Collections.sort(arr, Sort.BY_AREA_ASCENDING);
        assertEquals(arr.toString(), expecList.toString());
    }

    @Test
    public void testAreaSortDec() throws ShapeException {
        ArrayList<Shape> expecList = new ArrayList<Shape>();
        expecList.add(new Circle(5.5));
        // expecList.add(new Triangle(3, 4, 5));
        expecList.add(new Rectangle(1, 2));
        Collections.sort(arr, Sort.BY_AREA_DESCENDING);
        assertEquals(arr.toString(), expecList.toString());
    }

    @Test
    public void testPerimeterSortAec() throws ShapeException {
        ArrayList<Shape> expecList = new ArrayList<Shape>();
        expecList.add(new Rectangle(1, 2));
        // expecList.add(new Triangle(3, 4, 5));
        expecList.add(new Circle(5.5));
        Collections.sort(arr, Sort.BY_PERIMETER_ASCENDING);
        assertEquals(arr.toString(), expecList.toString());
    }

    @Test
    public void testPerimeterSortDec() throws ShapeException {
        ArrayList<Shape> expecList = new ArrayList<Shape>();
        expecList.add(new Circle(5.5));
        // expecList.add(new Triangle(3, 4, 5));
        expecList.add(new Rectangle(1, 2));
        Collections.sort(arr, Sort.BY_PERIMETER_DESCENDING);
        assertEquals(arr.toString(), expecList.toString());
    }
}