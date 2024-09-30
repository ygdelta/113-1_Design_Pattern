package com.example;
// TODO: Implement test of CaptionedContent.

public class CaptionedContent {
    private Content content;
    private Text caption;

    public CaptionedContent(Content content, Text caption) {
        this.content = content;
        this.caption = caption;
    }

    public Content getContent() {
        return this.content;
    }

    public Text getCaption() {
        return this.caption;
    }
}