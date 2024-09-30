package com.example;

public class Text implements Content {
    private final String content;
    Text(String text) {
        this.content = text;
    }

    @Override
    public String toString() {
        return this.content;
    }

    @Override
    public int wordCount() {
        return content.split("\\s+").length;
    }
}