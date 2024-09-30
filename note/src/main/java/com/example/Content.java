package com.example;
import java.util.Iterator;

public interface Content {
    default Iterator<Content> iterator() {
        return null;
    }
    default int wordCount() {
        return 0;
    }
}
