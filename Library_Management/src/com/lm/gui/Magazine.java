package com.lm.gui;

public class Magazine extends LibraryItem {
    private String issue;

    public Magazine(String id, String issue) {
        super(id);
        this.issue = issue;
    }

    public String getIssue() {
        return issue;
    }
}
