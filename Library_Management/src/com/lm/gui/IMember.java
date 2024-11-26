package com.lm.gui;

public interface IMember {
    String getId();
    String getInfo();
    boolean borrowItem(LibraryItem item);
    void returnItem(LibraryItem item);
}

