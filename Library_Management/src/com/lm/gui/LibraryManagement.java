package com.lm.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// LibraryManagement class to handle the GUI and functionality
public class LibraryManagement {
    private JFrame frame; // Main application window
    private JPanel panel; // Panel to organize elements in the window
    private JButton addBookButton;
    private JButton addMemberButton;
    private JButton borrowItemButton;
    private JButton returnItemButton;

    // LibraryManager to handle the backend logic
    private LibraryManager libraryManager;

    public LibraryManagement() {
        // Initialize the LibraryManager instance
        libraryManager = new LibraryManager();

        // Initialize UI components
        frame = new JFrame();
        panel = new JPanel();
        addBookButton = new JButton("Add Book");
        addMemberButton = new JButton("Add Member");
        borrowItemButton = new JButton("Borrow Item");
        returnItemButton = new JButton("Return Item");

        // Add Action Listeners for buttons
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookId = JOptionPane.showInputDialog("Enter Book ID:");
                String bookTitle = JOptionPane.showInputDialog("Enter Book Title:");
                if (bookId != null && bookTitle != null && !bookId.isEmpty() && !bookTitle.isEmpty()) {
                    libraryManager.addLibraryItem(new Book(bookId, bookTitle));
                    JOptionPane.showMessageDialog(frame, "Book added successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid input! Please try again.");
                }
            }
        });

        addMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberName = JOptionPane.showInputDialog("Enter Member Name:");
                if (memberName != null && !memberName.isEmpty()) {
                    libraryManager.addMember(new StudentMember(memberName));
                    JOptionPane.showMessageDialog(frame, "Member added successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid input! Please try again.");
                }
            }
        });

        borrowItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberId = JOptionPane.showInputDialog("Enter Member ID:");
                String bookId = JOptionPane.showInputDialog("Enter Book ID:");
                if (memberId != null && bookId != null && !memberId.isEmpty() && !bookId.isEmpty()) {
                    try {
                        IMember member = libraryManager.getMemberById(memberId);
                        LibraryItem item = libraryManager.getLibraryItemById(bookId);
                        if (item != null && member != null) {
                            libraryManager.borrowItem(member, item);
                            JOptionPane.showMessageDialog(frame, "Item borrowed successfully!");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Member or item not found!");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid input! Please try again.");
                }
            }
        });

        returnItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberId = JOptionPane.showInputDialog("Enter Member ID:");
                String bookId = JOptionPane.showInputDialog("Enter Book ID:");
                if (memberId != null && bookId != null && !memberId.isEmpty() && !bookId.isEmpty()) {
                    try {
                        IMember member = libraryManager.getMemberById(memberId);
                        LibraryItem item = libraryManager.getLibraryItemById(bookId);
                        if (item != null && member != null) {
                            libraryManager.returnItem(member, item);
                            JOptionPane.showMessageDialog(frame, "Item returned successfully!");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Member or item not found!");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid input! Please try again.");
                }
            }
        });

        // Layout for the panel
        panel.setLayout(new GridLayout(0, 1));
        panel.add(addBookButton);
        panel.add(addMemberButton);
        panel.add(borrowItemButton);
        panel.add(returnItemButton);

        // Set up the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("Library Management System");
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    // Main method to launch the application
    public static void main(String[] args) {
        new LibraryManagement();
    }
}

