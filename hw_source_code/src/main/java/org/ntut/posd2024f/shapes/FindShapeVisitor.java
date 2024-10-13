package org.ntut.posd2024f.shapes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class FindShapeVisitor implements Visitor<List<Shape>> {
    private Predicate<Shape> condition;
    private List<Shape> result;
    public FindShapeVisitor(Predicate<Shape> condition) {
        this.condition = condition;
        result = new ArrayList<>();
    }

    @Override
    public void visitCircle(Circle circle) {
        if (this.condition.test(circle)) {
            this.result.add(circle);
        }
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        if (this.condition.test(rectangle)) {
            this.result.add(rectangle);
        }
    }

    @Override
    public void visitTriangle(Triangle triangle) {
        if (this.condition.test(triangle)) {
            this.result.add(triangle);
        }
    }

    @Override
    public void visitConvexPolygon(ConvexPolygon convexPolygon) {
        if (this.condition.test(convexPolygon)) {
            this.result.add(convexPolygon);
        }
    }

    @Override
    public void visitCompoundShape(CompoundShape compoundShape) {
        if (this.condition.test(compoundShape)) {
            this.result.add(compoundShape);
        }
        Iterator<Shape> it = compoundShape.iterator();
        while (it.hasNext()) {
            it.next().accept(this);
        }
    }

    @Override
    public void visitTextedShape(TextedShape textedShape) {
        if (this.condition.test(textedShape)) {
            this.result.add(textedShape);
        }
        textedShape.getShape().accept(this);
    }

    @Override
    public void visitColoredShape(ColoredShape coloredShape) {
        if (this.condition.test(coloredShape)) {
            this.result.add(coloredShape);
        }
        coloredShape.getShape().accept(this);
    }

    public List<Shape> getResult() {
        return this.result;
    }
}