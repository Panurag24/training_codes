package com;

import java.util.Scanner;

public class TestBook {
    public static Book[] createBooks(int n) {
        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter book title: ");
            String title = scanner.nextLine();
            System.out.print("Enter book price: ");
            double price = Double.parseDouble(scanner.nextLine());
            books[i] = new Book(title, price);
        }
        return books;
    }

    public static void showBooks(Book[] books) {
        System.out.println("Book Title\tPrice");
        for (Book book : books) {
            System.out.println(book.getTitle() + "\t" + book.getPrice());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of books: ");
        int n = Integer.parseInt(scanner.nextLine());
        Book[] books = createBooks(n);
        showBooks(books);
    }
}
