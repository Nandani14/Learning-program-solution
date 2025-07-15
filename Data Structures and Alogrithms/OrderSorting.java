// OrderSorting.java - Sort customer orders by price using Bubble Sort and Quick Sort

import java.util.*;

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int id, String name, double price) {
        orderId = id;
        customerName = name;
        totalPrice = price;
    }

    public String toString() {
        return orderId + " - " + customerName + " - ₹" + totalPrice;
    }
}

public class OrderSorting {

    // Bubble Sort
    public static void bubbleSort(List<Order> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).totalPrice > list.get(j + 1).totalPrice) {
                    // swap
                    Order temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(List<Order> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);
            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    public static int partition(List<Order> list, int low, int high) {
        double pivot = list.get(high).totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j).totalPrice < pivot) {
                i++;
                // swap
                Order temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        // swap pivot
        Order temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        return i + 1;
    }

    public static void printOrders(List<Order> list) {
        for (Order o : list) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "Nandani", 1200.0));
        orders.add(new Order(2, "Daksh", 900.5));
        orders.add(new Order(3, "Abhinav", 1500.75));
        orders.add(new Order(4, "Shikha", 700.25));

        System.out.println("Original Order List:");
        printOrders(orders);

        // Bubble sort
        System.out.println("\nUsing Bubble Sort:");
        bubbleSort(orders);
        printOrders(orders);

        // Re-initialize list for quick sort
        orders.clear();
        orders.add(new Order(1, "Nandani", 1200.0));
        orders.add(new Order(2, "Daksh", 900.5));
        orders.add(new Order(3, "Abhinav", 1500.75));
        orders.add(new Order(4, "Shikha", 700.25));

        // Quick sort
        System.out.println("\nUsing Quick Sort:");
        quickSort(orders, 0, orders.size() - 1);
        printOrders(orders);
    }
}

