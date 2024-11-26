package com.lm.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Member implements IMember {
    protected UUID id;
    protected String name;
    protected List<LibraryItem> borrowedItems;

    public Member(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getInfo() {
        return "Member ID: " + id + ", Name: " + name;
    }

    public boolean borrowItem(LibraryItem item) {
        if (item.isAvailable()) {
            borrowedItems.add(item);
            item.borrowItem();
            return true;
        }
        return false;
    }

    public void returnItem(LibraryItem item) {
        borrowedItems.remove(item);
        item.returnItem();
    }
}

