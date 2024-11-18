package org.ntut.posd2024f.shapes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ShapeParser {
    private Scanner scanner;
    private ShapeBuilder builder;
    private int braceCount = 0;
    
    public ShapeParser(File file) {
        try {
            scanner = new Scanner(file);
        }
        catch (FileNotFoundException e){
            throw new RuntimeException("File not found");
        }
        builder = new ShapeBuilder();
    }

    public ShapeParser(String str) {
        scanner = new Scanner(str);
        builder = new ShapeBuilder();
    }

    public void parse() {
        while (this.scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            if (line.startsWith("CompoundShape")) {
                ParseCompoundShape(line);
                this.braceCount++;
            }
            else ParseShape(line);
            if (line.contains("}")) {
                builder.endBuildCompoundShape();
                this.braceCount--;
            }
        }
        if (braceCount > 0) {
            throw new IllegalArgumentException("Expected token '}'");
        }
    }

    public List<Shape> getResult() {
        return builder.getResult();
    }

    private Map<String, String> ParseDecorator(String input) {
        Map<String, String> decorators = new HashMap<>();
        if (input.contains(",")) {
            String[] dParts = input.split(",");
            input = dParts[0];
            for (int i = 1; i < dParts.length; i++) {
                String[] decorator = dParts[i].trim().split("=", 2);
                decorators.put(decorator[0], decorator[1]); // something like <"color", "RED">
            }
        }
        decorators.put("args", input);
        return decorators;
    }

    private void ParseShape(String line) {
        String[] divide = line.split(" ", 2);
        String shapeType = divide[0];
        String args = divide.length > 1 ? divide[1] : "";
        Map<String, String> settings = new HashMap<>();

        if (shapeType.equals("Triangle") || shapeType.equals("ConvexPolygon")) {
            int bracketIdx = args.lastIndexOf("]");
            if (bracketIdx < args.length() - 1) {
                String dPart = args.substring(bracketIdx + 1).trim();
                settings = ParseDecorator(dPart);
            }
            args = args.substring(0, bracketIdx + 1);
        }
        else {
            settings = ParseDecorator(args);
            args = settings.get("args");
        }
        String color = settings.get("color");
        String text = settings.get("text");

        // Construct Shape
        switch(shapeType) {
        case "Circle":
            double radius = Double.parseDouble(args.trim());
            builder.buildCircle(radius, color, text);
            break;
        case "Rectangle":
            String[] rectArgs = args.split(" ");
            double length = Double.parseDouble(rectArgs[0].trim());
            double width = Double.parseDouble(rectArgs[1].trim());
            builder.buildRectangle(length, width, color, text);
            break;
        case "Triangle":
        case "ConvexPolygon":
            List<TwoDimensionalVector> vectors = parseVectors(args);
            if (shapeType.equals("Triangle")) {
                builder.buildTriangle(vectors, color, text);
            }
            else {
                builder.buildConvexPolygon(vectors, color, text);
            }
            break;
        }
    }
    
    private List<TwoDimensionalVector> parseVectors(String input) {
        List<TwoDimensionalVector> vectors = new ArrayList<>();
        try (Scanner vectorScanner = new Scanner(input)) {
            vectorScanner.useDelimiter("\\s+");
            while (vectorScanner.hasNext()) {
                String vectorStr = vectorScanner.next();
                if (!vectorStr.startsWith("[")) throw new IllegalArgumentException("Expected token '['");
                if (!vectorStr.contains(",")) throw new IllegalArgumentException("Expected token ','");
                if (!vectorStr.endsWith("]")) throw new IllegalArgumentException("Expected token ']'");
                String[] components = vectorStr.substring(1, vectorStr.length() - 1).split(",");
                vectors.add(new TwoDimensionalVector(
                    Integer.parseInt(components[0]),
                    Integer.parseInt(components[1])
                ));
            }
        }
        return vectors;
    }

    private void ParseCompoundShape(String line) {
        if (!line.contains("{")) {
            throw new IllegalArgumentException("Expected token '{'");
        }
        int bIdx = line.indexOf("{");
        String header = line.substring(0, bIdx).trim();

        // Parse decorator part
        Map<String, String> settings = ParseDecorator(header);
        String color = settings.get("color");
        String text = settings.get("text");
        builder.beginBuildCompoundShape(color, text);
    }
}
