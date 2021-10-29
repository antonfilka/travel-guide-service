package com.example.travelguideservice.model;

public class TestMessage {

    private String text;
    private String author;
    private long id;

    public TestMessage() {
    }

    public TestMessage(long id, String text, String author) {
        this.id = id;
        this.text = text;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
