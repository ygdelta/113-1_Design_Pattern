package com.example;
import java.util.Iterator;

public interface Content {
    default Iterator<Content> iterator() {
        return null;
    }
}
