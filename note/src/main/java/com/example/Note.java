package com.example;

import java.util.ArrayList;
import java.util.List;

public class Note {
    private List<Content> contents = new ArrayList<>();
    public void addContent(Content content) {
        this.contents.add(content);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Content content: this.contents) {
            sb.append(content.toString()).append("\n");
        }
        return sb.toString();
    }
}
