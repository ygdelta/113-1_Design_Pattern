package com.example;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ContentTest {
    @Test
    void testTextCreation() {
        Content text = new Text("Hello World!");
        assertEquals("Hello World", text.toString());
    }

    @Test
    public void testHybridContentCreation() {
        Content t1 = new Text("Hellow,");
        Content t2 = new Text(" World!");
        List<Content> contents = new ArrayList<>();
        contents.add(t1);
        contents.add(t2);
        Content hybridContent = new HybridContent(contents);
        assertEquals("Hello, World!", hybridContent.toString());
    }
}