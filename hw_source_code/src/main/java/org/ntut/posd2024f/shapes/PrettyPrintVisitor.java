package org.ntut.posd2024f.shapes;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PrettyPrintVisitor implements Visitor<String>{
    private String result = "";
    private static final String RED = "\033[0;31m";
    private static final String GREEN = "\033[0;32m";
    private static final String BLUE = "\033[0;34m";
    private static final String RESET = "\033[0m";
    private static final String indent = "  ";
    private int level = 0;

    @Override
    public void visitCircle(Circle circle) {
        if (needInsertNewLine()) {
            result += "\n";
        }
        result += "Circle " + Double.toString(circle.getRadius());
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        if (needInsertNewLine()) {
            result += "\n";
        }
        result += "Rectangle " + Double.toString(rectangle.getLength()) + " " + Double.toString(rectangle.getWidth());
    }

    @Override
    public void visitTriangle(Triangle triangle) {
        if (needInsertNewLine()) {
            result += "\n";
        }
        result += "Triangle ";
        for (TwoDimensionalVector v: triangle.getVectors()) {
            result += v.toString() + " ";
        }
        result = result.substring(0, result.length() - 1);
    }

    @Override
    public void visitConvexPolygon(ConvexPolygon convexPolygon) {
        if (needInsertNewLine()) {
            result += "\n";
        }
        result += "ConvexPolygon ";
        for (TwoDimensionalVector v: convexPolygon.getVectors()) {
            result += v.toString() + " ";
        }
        result = result.substring(0, result.length() - 1);
    }

    @Override
    public void visitCompoundShape(CompoundShape compoundShape) {
        if (needInsertNewLine()) {
            result += "\n";
        }
        result += "CompoundShape {";
        level += 1;
        List<Shape> shapes = compoundShape.getShapes();
        for (Shape s: shapes) {
            result += "\n" + String.join("", Collections.nCopies(level, indent));
            s.accept(this);
        }
        if (result.charAt(result.length() - 1) != '{') {
            result += "\n" + String.join("", Collections.nCopies(level - 1, indent));
        }
        result += "}";
        level -= 1;
    }

    @Override
    public void visitTextedShape(TextedShape textedShape) {
        textedShape.getShape().accept(this);
        result += ", text: " + textedShape.getText();
    }

    @Override
    public void visitColoredShape(ColoredShape coloredShape) {
        if (needInsertNewLine()) {
            result += "\n";
        }
        String prev = this.result;
        String temp = "";
        this.result = temp;
        switch(coloredShape.getColor()) {
        case "RED":
            prev += RED;
            break;
        case "GREEN":
            prev += GREEN;
            break;
        case "BLUE":
            prev += BLUE;
            break;
        }
        coloredShape.getShape().accept(this);
        prev += this.result;
        prev += RESET;
        this.result = prev;
    }

    @Override
    public String getResult() {
        return this.result;
    }

    private boolean needInsertNewLine() {
        String judge = "";
        if (this.result.length() == 0) {
            return false;
        }
        if (result.charAt(result.length() - 1) == ' ' && result.charAt(result.length() - 2) == ' ') {
            return false;
        }
        if (result.length() > RED.length()) {
            judge = result.substring(result.length() - RED.length() - 1, result.length() - 1);
            System.out.println(judge);
        }
        if (judge == RED || judge == BLUE || judge == GREEN) {
            return false;
        }
        return true;
    }
}
