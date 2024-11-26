package com.lm.gui;

public class Book extends LibraryItem {
    private String title;

    public Book(String id, String title) {
        super(id);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}