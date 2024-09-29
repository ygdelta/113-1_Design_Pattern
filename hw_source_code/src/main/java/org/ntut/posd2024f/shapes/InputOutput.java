package org.ntut.posd2024f.shapes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

public class InputOutput {
    public InputOutput() {
    }

    public ArrayList<Shape> handleInput(String inputFileName) throws NumberFormatException, Exception {
        ArrayList<Shape> shape_arr = new ArrayList<Shape>();
        BufferedReader br = new BufferedReader(new FileReader(inputFileName));
        String line;
        while((line = br.readLine()) != null) {
            Shape shape = this.ConstructShape(line);
            if (shape != null) {
                shape_arr.add(shape);
            }
        }
        br.close();
        return shape_arr;
    }

    public ArrayList<Shape> handleSort(ArrayList<Shape> Shapes, String compare, String order) {
        switch (compare) {
        case "area":
            if (order.equals("inc")) {
                Collections.sort(Shapes, Sort.BY_AREA_ASCENDING);
            }
            else if (order.equals("dec")){
                Collections.sort(Shapes, Sort.BY_AREA_DESCENDING);
            }
            break;
        case "perimeter":
            if (order.equals("inc")) {
                Collections.sort(Shapes, Sort.BY_PERIMETER_ASCENDING);
            }
            else if (order.equals("dec")){
                Collections.sort(Shapes, Sort.BY_PERIMETER_DESCENDING);
            }
            break;
        }
        return Shapes;
    }

    public void handleOutput(ArrayList<Shape> Shapes, String outputFileName) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName));
        String line = "";
        for (Shape shape: Shapes) {
            line = shape.toString();
            bw.write(line);
            bw.newLine();
        }
        bw.close();
    }

    private Shape ConstructShape(String str) throws NumberFormatException, Exception {
        String[] param = str.split(" ");
        String shape_type = param[0];
        Shape shape = null;
        switch (shape_type) {
        case "Circle":
            if (param.length != 2) {
                throw new Exception("It's not a circle!");
            }
            shape = new Circle(Double.valueOf(param[1]));
            break;
        case "Triangle":
            if (param.length != 4) {
                throw new Exception("It's not a triangle!");
            }
            shape = new Triangle(Double.valueOf(param[1]), Double.valueOf(param[2]), Double.valueOf(param[3]));
            break;
        case "Rectangle":
            if (param.length != 3) {
                throw new Exception("It's not a rectangle!");
            }
            shape = new Rectangle(Double.valueOf(param[1]), Double.valueOf(param[2]));
            break;
        default:
            break;
        }
        return shape;
    }
}
