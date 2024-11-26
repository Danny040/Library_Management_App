package com.lm.gui;

import java.util.Date;
import java.util.UUID;

public class LibraryItem {
    private String id;
    private UUID memberId;
    private boolean availability;
    private Date dueToDate;

    public LibraryItem(String id) {
        this.id = id;
        this.availability = true;
    }

    public String getId() {
        return id;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void borrowItem() {
        this.availability = false;
    }

    public void returnItem() {
        this.availability = true;
    }
}