package com.lm.gui;

import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    private List<LibraryItem> libraryItems;
    private List<IMember> members;

    public LibraryManager() {
        libraryItems = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addLibraryItem(LibraryItem item) {
        libraryItems.add(item);
    }

    public void removeLibraryItem(LibraryItem item) {
        libraryItems.remove(item);
    }

    public void addMember(IMember member) {
        members.add(member);
    }

    public void removeMember(IMember member) {
        members.remove(member);
    }

    public void borrowItem(IMember member, LibraryItem item) {
        if (member.borrowItem(item)) {
            System.out.println("Item borrowed successfully.");
        } else {
            System.out.println("Item is not available.");
        }
    }

    public void returnItem(IMember member, LibraryItem item) {
        member.returnItem(item);
        System.out.println("Item returned successfully.");
    }

    public IMember getMemberById(String id) {
        for (IMember member : members) {
            if (member.getId().toString().equals(id)) {
                return member;
            }
        }
        return null;
    }

    public LibraryItem getLibraryItemById(String id) {
        for (LibraryItem item : libraryItems) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

}

