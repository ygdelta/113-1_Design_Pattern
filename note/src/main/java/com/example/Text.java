package com.example;

public class Text implements Content {
    private String text;
    Text(String text) {
        this.text = text;
    }
    public String toString() {
        return this.text;
    }
}