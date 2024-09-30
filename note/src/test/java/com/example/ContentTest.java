package com.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
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
        Content t1 = new Text("Hellow, ");
        Content t2 = new Text("World!");
        List<Content> contents = new ArrayList<>();
        contents.add(t1);
        contents.add(t2);
        Content hybridContent = new HybridContent(contents);
        assertEquals("Hello, World!", hybridContent.toString());
    }

    @Test
    public void accessContentOfHybridContent() {
        Content t1 = new Text("Hello, ");
        Content t2 = new Text("World!");
        List<Content> contents = new ArrayList<>();
        contents.add(t1);
        contents.add(t2);
        HybridContent hybridContent = new HybridContent(contents);
        Iterator<Content> iterator = hybridContent.iterator();
        assertEquals("Hello, ", iterator.next().toString());
        assertEquals("World!", iterator.next().toString());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testReturnEmptyIterator() {
        Content text = new Text("test");
        Iterator<Content> it = text.iterator();
        assertEquals(null, it);
    }
    
    @Test
    public void testPictureGetImageData() throws FileNotFoundException {
        Picture pic = new Picture("src/test/resources/blue_image.png");
        int[][] imageData = new int[100][300];
        imageData = pic.getImageData();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 300; j++) {
                // TODO: assertEqual the pixel in image.
            }
        }
    }
    
    @Test
    public void testWordCount() {
        Content text = new Text("Hello World!");
        assertEquals(2, text.wordCount());
    }

    @Test
    public void testPicWordCount() {
        Picture pic = new Picture("src/test/resources/blue_image.png");
        assertEquals(1000, pic.wordCount());
    }

    @Test
    public void testCaptionedContentWordCount() {
        Content pic = new Picture("src/test/resources/blue_image.png");
        Text caption = new Text("Hellow World!");
        List<Content> contents = new ArrayList<>();
        contents.add(pic);
        contents.add(caption);
        HybridContent hybridContent = new HybridContent(contents);
        assertEquals();
    }
}