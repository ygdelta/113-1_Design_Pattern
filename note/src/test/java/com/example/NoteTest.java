package com.example;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NoteTest {
    @Test
    void testNoteCreation() {
        Note note = new Note();
        note.addContent(new Text("Hellow World!"));
        note.addContent(new Text("Goodbye World!"));
        assertEquals("Hellow World!\nGoodbye World!\n", note.toString());
    }
}
