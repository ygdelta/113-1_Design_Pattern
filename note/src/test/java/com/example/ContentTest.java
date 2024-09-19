package com.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ContentTest {
    @Test
    void testTextCreation() {
        Content text = new Text("Hello World!");
        assertEquals("Hello World", text.toString());
    }
}