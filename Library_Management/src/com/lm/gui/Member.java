package com.lm.gui;

import java.util.ArrayList;
import java.util.List;

public abstract class Member implements IMember {
    protected String id;
    protected String name;
    protected List<LibraryItem> borrowedItems;

    public Member(String name, String id) {
        this.id = id;
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    public String getId() {
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

