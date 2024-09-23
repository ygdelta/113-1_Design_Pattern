package com.example;

import java.util.List;

public class HybridContent implements Content {
    private List<Content> contents;
    public HybridContent(List<Content> contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Content content: this.contents) {
            sb.append(content.toString()).append("");
        }
        return sb.toString();
    }
}
