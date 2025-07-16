// LibrarySearch.java - Find books using linear and binary search

import java.util.*;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int id, String title, String author) {
        this.bookId = id;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return bookId + " - " + title + " by " + author;
    }
}

public class LibrarySearch {

    // Linear search by title
    public static Book linearSearch(List<Book> books, String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    // Binary search by title (assumes sorted list)
    public static Book binarySearch(List<Book> books, String title) {
        int low = 0, high = books.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books.get(mid).title.compareToIgnoreCase(title);
            if (cmp == 0) return books.get(mid);
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(101, "The Alchemist", "Paulo Coelho"));
        books.add(new Book(102, "Java Programming", "Nandani Goswami"));
        books.add(new Book(103, "Clean Code", "Robert Martin"));
        books.add(new Book(104, "Design Patterns", "Erich Gamma"));

        System.out.println("--- Linear Search (unsorted) ---");
        Book result1 = linearSearch(books, "Clean Code");
        System.out.println(result1 != null ? result1 : "Book not found");

        // Sort by title for binary search
        books.sort(Comparator.comparing(b -> b.title.toLowerCase()));

        System.out.println("\n--- Binary Search (sorted) ---");
        Book result2 = binarySearch(books, "Java Programming");
        System.out.println(result2 != null ? result2 : "Book not found");
    }
}

